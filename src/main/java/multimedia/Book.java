package multimedia;

public class Book extends Item {
    private String author;
    private String publisher;

    public Book(String name, String path, String id, String author, String publisher) {
        super(name, path, id);
        this.author = author;
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                super.toString() +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
