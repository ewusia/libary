package lab.library.service;

import lab.library.model.Publisher;
import lab.library.service.api.BrowsingService;
import lab.library.service.impl.BrowsingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BrowsingServiceStarter {

    public static void main(String[] args) {
        System.out.println("BrowsingServiceStarter.main");

        ApplicationContext context = new AnnotationConfigApplicationContext("lab.library");
        BrowsingService bs = context.getBean(BrowsingService.class);
        
        Publisher p = bs.getPublisher(1L);

        System.out.println("p = " + p);
        
        
    }
}
