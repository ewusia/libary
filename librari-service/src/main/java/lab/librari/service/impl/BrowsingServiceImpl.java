package lab.librari.service.impl;


import lab.librari.dao.BooksDAO;
import lab.librari.dao.impl.InMemoryBooksDAO;
import lab.librari.model.Book;
import lab.librari.model.Page;
import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;

import java.util.List;
import java.util.logging.Logger;


public class BrowsingServiceImpl implements BrowsingService {

    Logger logger = Logger.getLogger(BrowsingServiceImpl.class.getName());

    private static BooksDAO bDao = new InMemoryBooksDAO();

    public List<Publisher> getPublishers() {
        return bDao.getAllPublishers();
    }

    @Override
    public Page<Publisher> getPublishersPage(int pageNumber, int pageSize) {
        return new Page<>(
                bDao.getPublishersPage(pageNumber, pageSize),
                bDao.getAllPublishers().size(),
                pageNumber,
                pageSize);
    }

    public Publisher getPublisher(Long id) {
        return bDao.getPublisherById(id);
    }


    public List<Book> getBooksForPublisher(Long rId) {
        Publisher r = getPublisher(rId);
        return bDao.getBooksByPublisher(r);
    }

    public Book getBookById(Long mId) {
        return bDao.getBookById(mId);
    }

    public Publisher addPublisher(Publisher p) {
        return bDao.addPublisher(p);
    }



    public Book addBook(Publisher p, Book b) {

        logger.info("about to add publisher " + p + " and book " + b);

        p = p.getId() == null ? bDao.addPublisher(p) : bDao.getPublisherById(p.getId());
        b.setPublisher(p);
        b = bDao.addBook(b);

        return b;
    }

}
