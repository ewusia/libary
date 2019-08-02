package lab.librari.web.controler;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;

public class TimeInterseptor extends HandlerInterceptorAdapter {

    int opening;
    int closing;

    public void setOpening(int opening) {
        this.opening = opening;
    }

    public void setClosing(int closing) {
        this.closing = closing;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        int hour = LocalTime.now().getHour();

        if (hour>=opening && hour<closing) {
            return true;
        } else {
            response.sendRedirect("https://www.washingtonpost.com/resizer/TEH64ArccQWgFU--s18t0x8PFFk=/1400x0/arc-anglerfish-washpost-prod-thelily-washpost.s3.amazonaws.com/public/YPRFSHTXZZCLDFKVV45F6RWWHY.gif");
            return false;
        }
    }
}
