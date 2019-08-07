package lab.library.dao.impl.jdbc;


import lab.library.dao.BooksDAO;
import lab.library.model.Book;
import lab.library.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository // componet reposytory trzeba dodac by sie przeloczyc
//@Primary
public class JdbcBooksDAO implements BooksDAO {

    public static final Logger logger = Logger.getLogger(JdbcBooksDAO.class.getName());

    public static final String SELECT_ALL_PUBLISHERS = "select p.id as publisher_id, p.logoimage as publisher_logo, " +
            "p.name as publisher_name from publisher p";

    public static final String SELECT_PUBLISHER_BY_ID = "select p.id as publisher_id, p.logoimage as publisher_logo, " +
            "p.name as publisher_name from publisher p where id=?";

    public static final String SELECT_BOOK_BY_ID = "select b.id as book_id, " +
            "b.title as book_title, b.author as book_author, b.cover as book_cover, b.price as book_price," +
            "p.id as publisher_id, p.logoimage as publisher_logo, " +
            "p.name as publisher_name " +
            "from book b, publisher p where b.publisher_id = p.id and b.id = ?";

    public static final String SELECT_BOOKS_BY_PUBLISHER = "select b.id as book_id, " +
            "b.title as book_title, b.author as book_author, b.cover as book_cover,  b.price as book_price," +
            "p.id as publisher_id, p.logoimage as publisher_logo,  " +
            "p.name as publisher_name  " +
            "from book b, publisher p where b.publisher_id = p.id and p.id=?";


    public static final String INSERT_PUBLISHER = "insert into publisher " +
            "(id,name,logoimage) values(?, ?, ?)";


    public static final String INSERT_PUBLISHER_BOOK = "insert into book " +
            "(title,author,cover,price,publisher_id) values(?, ?, ?, ?, ?)";

    //@Autowired
    private DataSource dataSource;

    //@Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Publisher> publisherRowMapper = new PublisherMapper();

    @Override
    public List<Publisher> getAllPublishers() {
        List<Publisher> publishers = jdbcTemplate.query(SELECT_ALL_PUBLISHERS, publisherRowMapper);
                /*ArrayList<Publisher>();

        try(Connection con = this.dataSource.getConnection(); // polaczenia na tym statement i potem result, polaczenia c- conction uzysukujemy z dataSource
            Statement statement = con.createStatement();) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PUBLISHERS);
            while (resultSet.next()) {
                publishers.add(mapPublisher(resultSet));
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
        }*/

        return publishers;
    }

    @Override
    public List<Publisher> getPublishersPage(int pageNumber, int pageSize) {
        return null;
    }

    public Publisher getPublisherById(Long id) {

        Publisher p = null;
        try(Connection con = this.dataSource.getConnection();
            PreparedStatement prpstm = con.prepareStatement(SELECT_PUBLISHER_BY_ID);) {
            prpstm.setLong(1, id);
            ResultSet rs = prpstm.executeQuery();
            if(rs.next()) {
                p = mapPublisher(rs);
            }

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
        }
        return p;
    }

    public List<Book> getBooksByPublisher(Publisher p) {
        List<Book> books = new ArrayList<>();
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement prpstm = con.prepareStatement(SELECT_BOOKS_BY_PUBLISHER);) {
            prpstm.setLong(1, p.getId());
            ResultSet rs = prpstm.executeQuery();
            while(rs.next()){
                books.add(mapBook(rs, p));
            }

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
        }
        return books;
    }

    public Book getBookById(Long mId) {
        Book book = null;
        try(Connection con = this.dataSource.getConnection();
            PreparedStatement prpstm = con.prepareStatement(SELECT_BOOK_BY_ID);) {
            prpstm.setLong(1, mId);
            ResultSet rs = prpstm.executeQuery();
            if(rs.next()){
                book = mapBook(rs, null);
            }

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
        }
        return book;
    }


    public Publisher addPublisher(Publisher p) {
        throw new UnsupportedOperationException("not implemented yet");
        /*try(Connection con = this.dataSource.getConnection();
            PreparedStatement prpstm = con.prepareStatement(INSERT_PUBLISHER);) {
            prpstm.setLong(1, p.getId());
            prpstm.setString(2,p.getName());
            prpstm.setString(3,p.getLogoImage());

            prpstm.executeUpdate();

            p = getPublisherById(p.getId());

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
        }
        return p;*/
    }

    public Book addBook(Book b) {

        jdbcTemplate.update(
                INSERT_PUBLISHER_BOOK,
                b.getTitle(),
                b.getAuthor(),
                b.getCover(),
                b.getPrice(),

                b.getPublisher().getId()
                );

        /*try(Connection con = this.dataSource.getConnection();
            PreparedStatement prpstm = con.prepareStatement(INSERT_PUBLISHER_BOOK);) {
            //con.setAutoCommit(false);
            //prpstm.setLong(1, m.getId());
            prpstm.setString(1, m.getTitle());
            prpstm.setString(2, m.getAuthor());
            prpstm.setString(3, m.getCover());
            prpstm.setInt(4, m.getPrice());
            prpstm.setLong(5, m.getPublisher().getId());
            prpstm.executeUpdate();

            //m = getBookById(m.getId());

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
        }*/
        return b;
    }

    private Publisher mapPublisher(ResultSet rs) throws SQLException {
        Publisher r = new Publisher();
        r.setId(rs.getLong("publisher_id"));
        r.setName(rs.getString("publisher_name"));
        r.setLogoImage(rs.getString("publisher_logo"));
        return r;
    }

    private Book mapBook(ResultSet rs, Publisher r) throws SQLException {
        Book m = new Book();
        m.setId(rs.getLong("book_id"));
        m.setTitle(rs.getString("book_title"));
        m.setAuthor(rs.getString("book_author"));
        m.setCover(rs.getString("book_cover"));
        m.setPrice(rs.getInt("book_price"));
        if(r==null){
            r = mapPublisher(rs);
        }
        m.setPublisher(r);

        return m;
    }

}



