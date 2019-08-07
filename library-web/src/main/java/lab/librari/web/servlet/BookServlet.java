package lab.library.web.servlet;

import lab.library.model.Book;
import lab.library.service.api.BrowsingService;
import lab.library.service.impl.BrowsingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

//@WebServlet("/books")
public class BookServlet extends HttpServlet {

    Logger logger = Logger.getLogger(BookServlet.class.getName());

    private BrowsingService bs = new BrowsingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("list of books");

        long id = Long.parseLong(req.getParameter("publisherId"));

        List<Book> booksForPublisher = bs.getBooksForPublisher(id);

        req.setAttribute("books", booksForPublisher);

        req.getRequestDispatcher("/WEB-INF/jsp/books.jsp").forward(req, resp);


    }
}
