package lab.librari.service.api;

import lab.librari.model.Book;
import lab.librari.model.Page;
import lab.librari.model.Publisher;

import java.util.List;


public interface BrowsingService {

    List<Publisher> getPublishers();

    Page<Publisher> getPublishersPage(int pageNumber, int pageSize);

    public Publisher getPublisher(Long id);

    List<Book> getBooksForPublisher(Long pId);

    Book getBookById(Long bId);

    Publisher addPublisher(Publisher p);

    Book addBook(Publisher p, Book bm);
}
