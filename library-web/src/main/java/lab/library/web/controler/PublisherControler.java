package lab.library.web.controler;

import lab.library.model.Publisher;
import lab.library.service.api.BrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@Adviced
@RequestMapping("/publishers")
public class PublisherControler {

    Logger logger = Logger.getLogger(PublisherControler.class.getName());

    @Autowired
    BrowsingService bs;

    @GetMapping // wywolanie metody i dl ktorej
    public String getPublishers(Model model) {
        logger.info("about to fetch publishers list");

        List<Publisher> publishers = bs.getPublishers();

        model.addAttribute("publishers", publishers);

        return "publishers";
    }

    @GetMapping("/publishersData")
    public @ResponseBody List<Publisher> getPublishersData(){
        return bs.getPublishers(); // serializowana lista
    }

}
