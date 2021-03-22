package commands;

import multimedia.InvalidCatalogException;

public class ExitCommand extends Command{
    @Override
    public void run() {
        System.exit(0);
    }
}
