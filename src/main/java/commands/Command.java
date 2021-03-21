package commands;
import multimedia.Catalog;
import multimedia.InvalidCatalogException;

public abstract class Command {

    protected Catalog catalog;
    protected Command(Catalog catalog) {
        this.catalog = catalog;
    }

    protected Command() {
        catalog = null;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public abstract void run() throws InvalidCatalogException;
}
