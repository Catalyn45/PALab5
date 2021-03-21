package commands;
import multimedia.Catalog;
import multimedia.InvalidCatalogException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayCommand extends Command{
    private final List<String> idList;

    public PlayCommand(Catalog catalog) {
        super(catalog);
        idList = new ArrayList<>();
    }

    public void addId(String id) {
        idList.add(id);
    }

    @Override
    public void run() throws InvalidCatalogException {
        try {
            catalog.playAll(idList);
        } catch (IOException e) {
            throw new InvalidCatalogException(e.getMessage());
        }
    }
}
