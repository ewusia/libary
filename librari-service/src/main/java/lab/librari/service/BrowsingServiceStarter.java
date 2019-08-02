package lab.librari.service;

import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;
import lab.librari.service.impl.BrowsingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BrowsingServiceStarter {

    public static void main(String[] args) {
        System.out.println("BrowsingServiceStarter.main");

        ApplicationContext context = new AnnotationConfigApplicationContext("lab.librari");
        BrowsingService bs = context.getBean(BrowsingService.class);
        
        Publisher p = bs.getPublisher(1L);

        System.out.println("p = " + p);
        
        
    }
}
