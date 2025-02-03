// Base class
class Item {
    protected String title;
    protected String author;
    protected int publicationYear;

    public Item(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Derived class - Book
class Book extends Item {
    private String genre;

    public Book(String title, String author, int publicationYear, String genre) {
        super(title, author, publicationYear);
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Genre: " + genre);
    }
}

// Derived class - Magazine
class Magazine extends Item {
    private int issueNumber;

    public Magazine(String title, String author, int publicationYear, int issueNumber) {
        super(title, author, publicationYear);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Issue Number: " + issueNumber);
    }
}

// Demo
public class LibrarySystemDemo {
    public static void main(String[] args) {
        Book book = new Book("The Alchemist", "Paulo Coelho", 1988, "Fiction");
        Magazine magazine = new Magazine("National Geographic", "Editorial Team", 2023, 150);

        System.out.println("Book Details:");
        book.displayDetails();
        System.out.println("\nMagazine Details:");
        magazine.displayDetails();
    }
}
