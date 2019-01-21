package lab.librari.service.impl;

import lab.librari.model.Book;
import lab.librari.model.Order;
import lab.librari.service.api.OrderService;

import java.io.Serializable;
import java.util.Set;
import java.util.logging.Logger;

public class SessionOrderService implements OrderService, Serializable {

    Logger logger = Logger.getLogger(SessionOrderService.class.getName());

    private Order o;

    public void add(Book m) {
        o.addBook(m);
    }

    public void remove(Book m) {
        o.removeBook(m);
    }

    public Set<Book> getOrderedBooks() {
        return o.getBooks();
    }


    public void doit() {
       logger.info("order confirmation: " + o);
       o.reset();
    }

    public void clear() {
       o.reset();
    }
}
