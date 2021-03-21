package multimedia;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Item implements Serializable {
    private String id;
    private String name;
    private String path;

    public Item(String name, String path, String id) throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("The name can't be null or empty string");
        }

        if (path == null || path.equals("")) {
            throw new IllegalArgumentException("The path can't be null or empty string");
        }

        if (id == null || id.equals("")) {
            throw new IllegalArgumentException("The id can't be null or empty string");
        }

        this.name = name;

        if (!Files.exists(Paths.get(path)))
            throw new IllegalArgumentException("Invalid path");

        this.path = path;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("The name can't be null or empty string");
        }

        this.name = name;
    }

    public void setPath(String path) throws IllegalArgumentException {
        if (path == null || path.equals("")) {
            throw new IllegalArgumentException("The path can't be null or empty string");
        }

        if (!Files.exists(Paths.get(path)))
            throw new IllegalArgumentException("Invalid path");

        this.path = path;
    }

    public void setId(String id) throws IllegalArgumentException {
        if (id == null || id.equals("")) {
            throw new IllegalArgumentException("The id can't be null or empty string");
        }

        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'';
    }
}
