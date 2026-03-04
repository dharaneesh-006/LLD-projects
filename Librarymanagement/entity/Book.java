package entity;

public class Book {
    private long bookId = 1;
    private String title;
    private String author;
    private int no_of_copies;
    private int available_books;


    public Book(String title,String author,int no_of_copies, int available_books)
    {
        this.bookId = bookId;
        bookId++;
        this.title = title;
        this.author = author;
        this.available_books = available_books;
        this.no_of_copies = no_of_copies;
    }

    public long getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable_books(int available_books) {
        this.available_books = available_books;
    }

    public int getAvailable_books() {
        return available_books;
    }

    public void setNo_of_copies(int no_of_copies) {
        this.no_of_copies = no_of_copies;
    }

    public int getNo_of_copies() {
        return no_of_copies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
