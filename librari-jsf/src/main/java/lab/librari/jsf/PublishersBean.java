package lab.librari.jsf;

import lab.librari.model.Book;
import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;
import lab.librari.service.impl.BrowsingServiceImpl;

import javax.faces.bean.ManagedBean;
import java.util.List;

//@ManagedBean
public class PublishersBean {

    private BrowsingService bs = new BrowsingServiceImpl();

    //alternatywa
    private long publisherId;

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public List<Publisher> getPublishers() {
        return bs.getPublishers();
    }

    public List<Book> getBooks(String id){
        return bs.getBooksForPublisher(Long.parseLong(id));
    }

    public List<Book> getBooks(){
        return bs.getBooksForPublisher(publisherId);
    }

}
