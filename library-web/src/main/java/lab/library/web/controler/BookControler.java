package lab.library.web.controler;

import lab.library.model.Book;
import lab.library.model.Publisher;
import lab.library.service.api.BrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@Adviced
@RequestMapping("/books")
@SessionAttributes("publisher")
public class BookControler {

    Logger logger = Logger.getLogger(BookControler.class.getName());

    @Autowired
    BrowsingService bs; // usluga

    @Autowired
    BookValidator validator;

    @InitBinder("bookForm")
    void initBind(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    //@RequestMapping(value = "/books", method = RequestMethod.GET) // wywolanie metody i dl ktorej
    @GetMapping // wywolanie metody i dl ktorej
    public String getBooks(Model model, @RequestParam("publisherId") long publisherId) {
        logger.info("about to fetch books of publishers list " + publisherId);

        List<Book> books = bs.getBooksForPublisher(publisherId);

        model.addAttribute("books", books);
        model.addAttribute("publisherId", publisherId);

        return "books";
    }

    @GetMapping("/add")
    public String addBookPrepare(Model model, @RequestParam("publisherId") long publisherId) { // value jest opcjonalne jak jest jedn wartosc

        logger.info("preparing add book action for publisher" + publisherId);

        model.addAttribute("bookForm", new Book());
        model.addAttribute("publisher", bs.getPublisher(publisherId));

        return "addBook"; // zwrocenie widoku
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("bookForm") @Validated Book book,
                          BindingResult br, // kontener przetrzymujacy informacje o bledach
                          @SessionAttribute("publisher") Publisher p) { // zamawiamy obiekt z modelu o nazwie bookForm a publisher z zsesji

        logger.info("adding book " + book + " for publisher " + p.getId());

/*        if (br.hasErrors()) {
            return "addBook";
        }*/

        bs.addBook(p, book);

        return "redirect:/books?publisherId=" + p.getId(); //skladnia przekierowania
    }
}
