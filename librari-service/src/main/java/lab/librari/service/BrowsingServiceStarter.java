package lab.librari.service;

import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;

public class BrowsingServiceStarter {

    public static void main(String[] args) {
        System.out.println("BrowsingServiceStarter.main");

        BrowsingService bs = null;
        
        Publisher p = bs.getPublisher(1L);

        System.out.println("p = " + p);
        
        
    }
}
