package commands;

public class HelpCommand extends Command{

    static String helpMessage = "Usage: \n" +
            "\tadd <type>(can be --book or --movie) <name> <path> <id>\n" +
            "\tlist\n" +
            "\tsave <path>\n" +
            "\tload <path>\n" +
            "\tplay <id>\n" +
            "\treport\n" +
            "\thelp\n" +
            "\texit\n" +
            "\n";


    @Override
    public void run() {
        System.out.println(helpMessage);
    }
}
