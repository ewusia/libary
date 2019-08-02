package lab.librari.dao.impl.jpa;

import lab.librari.dao.BooksDAO;
import lab.librari.model.Book;
import lab.librari.model.Publisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Primary
public class JPABooksDAO implements BooksDAO {

    @PersistenceContext(name = "librariUnit")
    EntityManager em; /*=
            Persistence.createEntityManagerFactory("librariUnit")
                    .createEntityManager();
    // skonfigurowany obiekt ktory bedzie realzowal automatyzacje na poziomie mapowania encji*/

    @Override
    public List<Publisher> getAllPublishers() {
        // jpql - hql - hibernate query language, jpql inspirowany hql
        return em.createQuery("select p from Publisher p").getResultList();
    }

    @Override
    public List<Publisher> getPublishersPage(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return em.find(Publisher.class, id); //znajdz klucz w klasie Publisher
    }

    @Override
    public List<Book> getBooksByPublisher(Publisher p) {
        return em.
                createQuery("select b from Book b where b.publisher=:p"). //=:parametr; b.publisher.id=:p - opcjoanleni
        setParameter("p", p). // ustawienie parametru
        getResultList();
    }

    @Override
    public Book getBookById(Long mId) {
        return em.find(Book.class, mId);
    }

    @Override
    public Publisher addPublisher(Publisher r) {
        return null;
    }
// transakcyjnosc to czesc logiki biznesowej
    @Override
    //@Transactional(propagation = Propagation.NEVER) //Never - rzuci wyjatek w momencie wywolania tej metody
    public Book addBook(Book b) {
        em.persist(b); //insert
        return b; // wzbogacony poczatkowy obiekt o id wiec mozna go zwrocic
    }

}
