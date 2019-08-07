package lab.library.web.servlet;

import lab.library.model.Publisher;
import lab.library.service.api.BrowsingService;
import lab.library.service.impl.BrowsingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

//@WebServlet("/publishers")
public class PublisherServlet extends HttpServlet {

    Logger logger = Logger.getLogger(PublisherServlet.class.getName());

    private BrowsingService bs = new BrowsingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("about to fetch publishers list");

        //long id = Long.parseLong(req.getParameter("publisherId"));

        List<Publisher> publishers = bs.getPublishers(); // komunikacja z warstawa uslug

        req.setAttribute("publishers", publishers);
        req.setAttribute("slogan", "Because you read");

        req.getRequestDispatcher("/WEB-INF/jsp/publishers.jsp").forward(req, resp);

    }
}
