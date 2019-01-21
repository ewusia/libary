package lab.librari.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class Publisher implements Serializable {

    private Long id;

    private String name;

    private String logoImage;

    private List<Book> books = new ArrayList<Book>();


    // don't use parametrized constructors - required for in-memory mockup only
    public Publisher(Long id, String name, String logoImage) {
        this.id = id;
        this.name = name;
        this.logoImage = logoImage;
    }

    public Publisher() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoImage='" + logoImage + '\'' +
                '}';
    }
}
