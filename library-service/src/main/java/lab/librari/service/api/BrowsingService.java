package lab.library.service.api;

import lab.library.model.Book;
import lab.library.model.Page;
import lab.library.model.Publisher;

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
