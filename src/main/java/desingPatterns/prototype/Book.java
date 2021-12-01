package desingPatterns.prototype;

public class Book extends Item {
    private String author;

    public Book(String name, String imgUrl, double price) {
        super(name, imgUrl, price);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }
}
