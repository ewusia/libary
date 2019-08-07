package lab.library.web.controler;

import lab.library.model.Book;
import lab.library.model.Publisher;
import lab.library.service.api.BrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // to co controler tylko dla resta
@RequestMapping("/rest")
public class PublisherRest {

    @Autowired
    BrowsingService bs;

    @GetMapping("/publishers")
    public List<Publisher> getPublishersData(){
        return bs.getPublishers(); // serializowana lista
    }

    @GetMapping("/publishers/{id}")
    public Publisher getPublisher(@PathVariable("id") long publisherId) {
        return bs.getPublisher(publisherId);
    }

    @GetMapping("/publishers/{id}/books")
    public List<Book> getBooks(@PathVariable("id") long publisherId) {

        return bs.getBooksForPublisher(publisherId);
    }

    @PostMapping("/publishers/{id}/books")
    public ResponseEntity<Book> addBook( //kontener na book jak i na odpowiedz
            @PathVariable("id") long publisherId, @RequestBody Book book) {

        book =  bs.addBook(bs.getPublisher(publisherId), book);

        return ResponseEntity.status(HttpStatus.CREATED).body(book);
        //return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}
