package lab.library.service.api;

import lab.library.model.Book;

import java.util.Set;


public interface OrderService {

    void add(Book m);

    void remove(Book m);

    Set<Book> getOrderedBooks();

    void doit();

    void clear();

}
