package commands;
import multimedia.Catalog;

public class ListCommand extends Command{
    public ListCommand(Catalog catalog)  {
        super(catalog);
    }

    @Override
    public void run() {
        catalog.list();
    }
}
