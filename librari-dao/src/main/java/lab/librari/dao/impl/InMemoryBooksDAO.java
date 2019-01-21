package lab.librari.dao.impl;

import lab.librari.dao.BooksDAO;
import lab.librari.model.Book;
import lab.librari.model.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class InMemoryBooksDAO implements BooksDAO {

    private Logger logger = Logger.getLogger(InMemoryBooksDAO.class.getName());

    private static List<Publisher> publishers = new ArrayList<>();

    private static List<Book> books = new ArrayList<>();

    static {

        Publisher p = new Publisher(1L, "O'Reilly",
                "http://2016.worldiaday.org/sites/default/files/oreilly.png");
        publishers.add(p);
        books.add(new Book(1L, "Learning Android", "Marko Gargenta", "http://akamaicovers.oreilly.com/images/0636920010883/cat.gif", 49, p));
        books.add(new Book(2L, "Getting started with SQL", "Thomas Nield", "http://akamaicovers.oreilly.com/images/0636920044994/cat.gif", 34, p));
        books.add(new Book(3L, "Learning Android", "Marko Gargenta", "http://akamaicovers.oreilly.com/images/0636920010883/cat.gif", 49, p));

        p = new Publisher(2L, "Microsoft Press",
                "https://upload.wikimedia.org/wikipedia/commons/4/4a/Microsoft_Press_Logo.svg");
        publishers.add(p);
        books.add(new Book(21L, "Programming for the Internet of Things: Using Windows 10 IoT Core and Azure IoT Suite", "Dawid Borycki", "https://i5.walmartimages.com/asr/6c8411bf-5615-429c-b9ab-3ee8171bafc6_1.f9dd41ce5641a78c2ae3b0b7240f83d7.jpeg?odnHeight=450&odnWidth=450&odnBg=FFFFFF", 49, p));
        books.add(new Book(22L, "Adaptive Code, Second Edition", "Gary McLean Hall", "https://target.scene7.com/is/image/Target/51710622?wid=520&hei=520&fmt=pjpeg", 19, p));

        p = new Publisher(3L, "MIT",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/MIT_Press_logo.svg/150px-MIT_Press_logo.svg.png");
        publishers.add(p);
        books.add(new Book(31L, "Deep Learning", "Ian Goodfellow, Yoshua Bengio and Aaron Courville", "https://mitpress.mit.edu/sites/default/files/imagecache/booklist_node/9780262035613_0.jpg", 19, p));
        books.add(new Book(32L, "Shape, Talking about Seeing and Doing", "George Stiny", "https://mitpress.mit.edu/sites/default/files/imagecache/booklist_default/9780262693677.jpg", 21, p));
        books.add(new Book(33L, "The Stuff of bits", "Paul Dourish", "https://mitpress.mit.edu/sites/default/files/imagecache/booklist_node/9780262036207.jpg", 24, p));

        p = new Publisher( 4L, "Pluralsight", "https://www.pluralsight.com/etc/clientlibs/pluralsight/main/images/global/header/PS_logo.png");
        books.add(new Book( 41L, "Python", "", "https://pluralsight.imgix.net/paths/python-7be70baaac.png?w=70", 5, "https://www.pluralsight.com/paths/python", p));
        books.add(new Book( 42L, "C#", "Scott Allen", "https://pluralsight.imgix.net/paths/path-icons/csharp-e7b8fcd4ce.png?w=70", 5, "https://www.pluralsight.com/paths/csharp", p));
        publishers.add(p);

        p = new Publisher( 5L, "Udemy", "https://www.udemy.com/staticx/udemy/images/v6/logo-coral.svg");
        books.add(new Book( 51L, "The Complete SQL Bootcamp", "Jose Portilla", "", 5, "https://www.udemy.com/the-complete-sql-bootcamp", p));
        publishers.add(p);

        p = new Publisher( 6L, "Wrox", "http://media.wiley.com/assets/253/59/wrox_logo.gif");
        books.add(new Book( 61L, "Professional Wordpress", "Brad Williams", "http://media.wiley.com/product_data/coverImage/41/11189872/1118987241.jpg", 5, "http://www.wrox.com/WileyCDA/WroxTitle/Professional-WordPress-Design-and-Development-3rd-Edition.productCd-1118987241.html", p));
        books.add(new Book( 62L, "Professional Hadoop Solutions", "Borys Lublinsky", "http://media.wiley.com/product_data/coverImage/34/11186119/1118611934.jpg", 5, "http://www.wrox.com/WileyCDA/WroxTitle/Professional-Hadoop-Solutions.productCd-1118611934.html", p));
        publishers.add(p);

        p = new Publisher( 7L, "SSI Logic", "http://www.ssilogic.com/Include/Images/logo-ssi.jpg");
        books.add(new Book( 71L, "ITIL Foundation Questions with Detailed Solutions", "Christopher Scordo", "https://images-na.ssl-images-amazon.com/images/I/51FUWmJzsAL._SX398_BO1,204,203,200_.jpg", 5, "https://www.amazon.com/gp/product/0982576811/ref=as_li_tf_tl?ie=UTF8&tag=sslowe-20&linkCode=as2&camp=1789&creative=9325&creativeASIN=0982576811", p));
        books.add(new Book( 72L, "PMI-ACP Exam Preparation", "Tim Bagnall", "https://www.amazon.com/gp/product/098947030X/ref=as_li_tf_tl?ie=UTF8&tag=sslowe-20&linkCode=as2&camp=1789&creative=9325&creativeASIN=098947030X", 5, "https://images-na.ssl-images-amazon.com/images/I/51DAJGiwk-L._SX398_BO1,204,203,200_.jpg", p));
        publishers.add(p);
    }


    public List<Publisher> getAllPublishers() {
        logger.info("fetching predefined list of publishers. elements:" + publishers.size());
        return publishers;
    }

    @Override
    public List<Publisher> getPublishersPage(int pageNumber, int pageSize) {
        return publishers.subList((pageNumber-1)*pageSize, pageNumber*pageSize);
    }

    public Publisher getPublisherById(Long id) {
        return publishers.stream().filter(p->p.getId()==id).findFirst().get();
    }

    public List<Book> getBooksByPublisher(Publisher p) {
        return books.stream().filter(b->b.getPublisher().getId()==p.getId()).collect(Collectors.toList());
    }

    public Book getBookById(Long bId) {
        return books.stream().filter(b->b.getId()==bId).findFirst().get();
    }

    public Publisher addPublisher(Publisher p) {
        final Long[] id = new Long[1];
        publishers.stream().max((p1,p2)->(int)(p1.getId()-p2.getId())).ifPresent(p1-> id[0] =p1.getId()+1);

        p.setId(id[0]);
        publishers.add(p);
        return p;
    }

    public Book addBook(Book b) {
        final Long[] id = new Long[1];
        books.stream().max((b1,b2)->(int)(b1.getId()-b2.getId())).ifPresent(b1-> id[0]=b1.getId()+1);

        b.setId(id[0]);
        books.add(b);
        return b;
    }

}
