package lab.library.web.controler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(annotations = Adviced.class)
public class LibraryAdvice {

    @ModelAttribute
    public void registerSlogan(Model model) {

        model.addAttribute("slogan", "Ucz sie, ucz..");
    }

    @ExceptionHandler(IllegalArgumentException.class) // ten wyjatek obsluony ta metoda
    public String handleException(Model model,
                                  IllegalArgumentException e,
                                    HttpServletResponse resp) {

        model.addAttribute("errorMessage", e.getMessage());
        resp.setStatus(400);
        return "error";
    }
}
