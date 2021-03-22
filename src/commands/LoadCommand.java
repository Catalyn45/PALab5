package commands;

import multimedia.Catalog;
import multimedia.InvalidCatalogException;

import java.io.*;

public class LoadCommand extends Command{
    private final String path;
    private final CatalogWrapper catalogWrapper;

    public LoadCommand(CatalogWrapper catalogWrapper, String path) {
        this.path = path;
        this.catalogWrapper = catalogWrapper;
    }

    @Override
    public void run() throws InvalidCatalogException {
        ObjectInputStream stream = null;

        try {
            stream = new ObjectInputStream(new FileInputStream(path));
            catalogWrapper.catalog = (Catalog)stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new InvalidCatalogException(e.getMessage());
        }
    }
}
