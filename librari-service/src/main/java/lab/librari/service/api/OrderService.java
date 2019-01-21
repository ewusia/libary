package lab.librari.service.api;

import lab.librari.model.Book;

import java.util.Set;


public interface OrderService {

    void add(Book m);

    void remove(Book m);

    Set<Book> getOrderedBooks();

    void doit();

    void clear();

}
