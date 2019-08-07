package lab.library.dao;

import lab.library.dao.impl.jpa.JPABooksDAO;
import lab.library.model.Publisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

@Configuration
@ImportResource("classpath:daoContext.xml")
public class SpringConfig {

    public static void main(String[] args) {
        System.out.println("SpringConfig.main");
        ApplicationContext context = new AnnotationConfigApplicationContext("lab.library");

        BooksDAO dao = context.getBean(BooksDAO.class);

        List<Publisher> publishers = dao.getAllPublishers();

        System.out.println("Publishers list:");
        for(Publisher p : publishers){
            System.out.println(p);
        }

    }
}
