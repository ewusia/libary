package lab.librari.dao;

import lab.librari.dao.impl.InMemoryBooksDAO;
import lab.librari.model.Publisher;

import java.util.List;

public class BooksDAOStarter {

    public static void main(String[] args) {
        System.out.println("BooksDAOStarter.main");

        BooksDAO dao = null;

        List<Publisher> publishers = dao.getAllPublishers();

        System.out.println("Publishers list:");
        for(Publisher p : publishers){
            System.out.println(p);
        }

    }
}
