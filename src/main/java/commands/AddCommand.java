package commands;

import multimedia.Catalog;
import multimedia.Item;

import java.util.ArrayList;
import java.util.List;

public class AddCommand extends Command {
    private final List<Item> itemList;
    public AddCommand(Catalog catalog) {
        super(catalog);
        itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    @Override
    public void run() {
        catalog.addList(itemList);
    }
}
