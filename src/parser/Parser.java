package parser;

import commands.*;
import multimedia.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ParserException extends Exception {
    ParserException(String message) {
        super(message);
    }
}

public class Parser {
    private final List<Command> commands;
    private CatalogWrapper catalogWrapper;

    public Parser(){
        commands = new ArrayList<>();
        catalogWrapper = null;
    }

    public void parse() throws ParserException {
        Item item = null;

        Scanner scanner = new Scanner(System.in);

        if(catalogWrapper == null) {
            System.out.print("Catalog name: ");
            catalogWrapper = new CatalogWrapper(new Catalog(scanner.nextLine()));
        }

        String[] commandLine = scanner.nextLine().split(" ");

        int index = 0;
        System.out.print("> ");
        while(index < commandLine.length){
            switch (commandLine[index++]) {
                case "add": {
                    String type = commandLine[index++];
                    String name = commandLine[index++];
                    String path = commandLine[index++];
                    String id = commandLine[index++];

                    if(type.equals("--movie")) {
                        int releaseYear = Integer.parseInt(commandLine[index++]);
                        int rating = Integer.parseInt(commandLine[index++]);

                        try {
                            item = new Movie(name, path, id, releaseYear, rating);
                        } catch (IllegalArgumentException e) {
                            throw new ParserException(e.getMessage());
                        }
                    } else if (type.equals("--book")) {
                        String author = commandLine[index++];
                        String publisher = commandLine[index++];

                        try {
                            item = new Book(name, path, id, author, publisher);
                        } catch (IllegalArgumentException e) {
                            throw new ParserException(e.getMessage());
                        }
                    } else {
                        throw new ParserException("Invalid argument");
                    }

                    AddCommand command = new AddCommand(catalogWrapper.catalog);
                    command.addItem(item);

                    commands.add(command);
                }
                break;

                case "list": {
                    ListCommand command = new ListCommand(catalogWrapper.catalog);
                    commands.add(command);
                }
                break;

                case "save" : {
                    String path = commandLine[index++];
                    SaveCommand command = new SaveCommand(catalogWrapper.catalog, path);
                    commands.add(command);
                }
                break;

                case "load" : {
                    String path = commandLine[index++];
                    LoadCommand command = new LoadCommand(catalogWrapper, path);
                    commands.add(command);
                }
                break;

                case "play": {
                    String id = commandLine[index++];
                    PlayCommand command = new PlayCommand(catalogWrapper.catalog);
                    command.addId(id);

                    commands.add(command);
                }
                break;

                case "report": {
                    ReportCommand command = new ReportCommand(catalogWrapper.catalog);
                    commands.add(command);
                }
                break;

                case "exit": {
                    commands.add(new ExitCommand());
                }
                break;

                case "help": {
                    commands.add(new HelpCommand());
                }
                break;
                default:
                    throw new ParserException("Invalid Command");
            }
        }
    }

    public void execute() throws ParserException {
        for (Command command : commands) {
            try {
                command.run();
            } catch (InvalidCatalogException e) {
                throw new ParserException(e.getMessage());
            }
        }

        commands.clear();
    }
}