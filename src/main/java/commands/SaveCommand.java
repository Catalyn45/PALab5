package commands;

import multimedia.Catalog;
import multimedia.InvalidCatalogException;

import java.io.*;

public class SaveCommand extends Command{
    private final String path;
    public SaveCommand(Catalog catalog, String path) {
        super(catalog);
        this.path = path;
    }

    @Override
    public void run() throws InvalidCatalogException {
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(path));
            stream.writeObject(catalog);
        } catch (IOException e) {
            throw new InvalidCatalogException(e.getMessage());
        }
    }
}
