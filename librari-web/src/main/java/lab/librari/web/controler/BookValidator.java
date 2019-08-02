package lab.librari.web.controler;

import lab.librari.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Book book = (Book) o;

        if (book.getPrice()<=0) {
            errors.rejectValue("price", "error.book.price.negative");
        }

/*        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            errors.rejectValue("title", "error.book.title.empty");
        } tozsame*/

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.book.title.empty");


    }
}
