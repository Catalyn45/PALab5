package multimedia;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Catalog implements Serializable{
    private final List<Item> items;
    private transient String name;

    public Catalog(String name) {
        items = new LinkedList<>();
        this.name = name;
    }

    public void addList(List<Item> itemList) {
        items.addAll(itemList);
    }

    public void list() {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    public void playAll(List<String> idList) throws IOException {
        for (Item item : items) {
            if (idList.contains(item.getId())) {
                File file = new File(item.getPath());
                    Desktop.getDesktop().open(file);
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
