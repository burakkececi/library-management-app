import java.util.Objects;

public class Book {
    private String ID;
    private String title;
    private String author;
    private String publisher;
    private String edition;

    private String genre;
    private int quantity;

    public Book(String ID, String title, String author, String publisher, String edition, String genre, int quantity) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.genre = genre;
        this.quantity = quantity;
    }

    public Book(Book oldBook){
        if(oldBook != null){
            this.ID = oldBook.ID;
            this.title = oldBook.title;
            this.author = oldBook.author;
            this.publisher = oldBook.publisher;
            this.edition = oldBook.edition;
            this.genre = oldBook.genre;
            this.quantity = oldBook.quantity;
        }
        System.out.println("Fatal Error: Creating copy constructor within Book Class.");
        System.exit(0);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID='" + ID + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Publisher='" + publisher + '\'' +
                ", Edition='" + edition + '\'' +
                ", Genre='" + genre + '\'' +
                ", Quantity='" + quantity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ID.equals(book.ID) && title.equals(book.title) && author.equals(book.author) && publisher.equals(book.publisher) && edition.equals(book.edition) && genre.equals(book.genre) && quantity == book.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, title, author, publisher, edition, genre, quantity);
    }
}
