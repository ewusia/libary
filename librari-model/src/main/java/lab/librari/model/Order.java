package lab.librari.model;


import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;


public class Order implements Serializable {

    private Long id;

    private Set<Book> books = new TreeSet<>((b1,b2)->b1.getTitle().compareTo(b2.getTitle()));

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void removeBook(Book b) {
        books.remove(b);
    }

    public void reset() {
        books.clear();
    }

    @Override
    public String toString() {
        return "Order{" +
                "books=" + books +
                '}';
    }
}
