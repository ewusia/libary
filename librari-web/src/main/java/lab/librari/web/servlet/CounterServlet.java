package lab.librari.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

//@WebServlet("/count")
public class CounterServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(CounterServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("counter servlet, doGet");

        int count = 0;

        HttpSession session = req.getSession(true);
        if (session.getAttribute("count") != null) {
            count = (int)session.getAttribute("count");
        }

        session.setAttribute("count", ++count);

        Cookie[] cookies = req.getCookies();
        boolean cookiesExist = false;
        for (Cookie cookie : cookies) {
            logger.info("cookie name: " + cookie.getName() + ", value: " + cookie.getValue());
            if (cookie.getName().equals("custom-cookie")){
                cookiesExist = true;
            }
        }
        Cookie cookie = new Cookie("custom-cookie", "custom-value");
        cookie.setMaxAge(60*5);
        resp.addCookie(cookie);

        /*resp.getWriter().write(
                "<html><body>" +
                        "This site has been visited " + count + " times" +
                        "</body></html>"
        );*/
        req.getRequestDispatcher("/WEB-INF/jsp/counter.jsp").forward(req, resp);
    }
}
