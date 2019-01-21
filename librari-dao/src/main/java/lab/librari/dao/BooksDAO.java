package lab.librari.dao;


import lab.librari.model.Book;
import lab.librari.model.Publisher;

import java.util.List;

public interface BooksDAO{

    List<Publisher> getAllPublishers();

    List<Publisher> getPublishersPage(int pageNumber, int pageSize);

    Publisher getPublisherById(Long id);

    List<Book> getBooksByPublisher(Publisher r);

    Book getBookById(Long mId);

    Publisher addPublisher(Publisher r);

    Book addBook(Book m);

}
