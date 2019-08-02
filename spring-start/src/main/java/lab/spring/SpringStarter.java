package lab.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStarter {

    public static void main(String[] args) {
        System.out.println("SpringStarter.main");

        ApplicationContext context =
                //new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
                new AnnotationConfigApplicationContext(Config.class);

        Box box = //(Box) context.getBean("box"); // jesli wiecej obiektow
/*                new Box();
        box.setElement(new Candies());*/
            context.getBean(Box.class); // jesli jeden obiekt danego typu, nie trzeba rzutowac

       /* Box box2 =
                context.getBean(Box.class); // jesli jeden obiekt danego typu, nie trzeba rzutowac*/

        System.out.println("{" + box.describeContent() + "}");

/*        Candies c = context.getBean(Candies.class);
        System.out.println(c.getDescription());*/ // wywolanie eelemntu pierwszego

/*        Candies c = (Candies) context.getBean("element2");
        System.out.println(c.getDescription());*/

/*        Element e = (Element) context.getBean("element2");
        System.out.println(e.getDescription());*/

/*        Element e = (Element) context.getBean("c2");
        System.out.println(e.getDescription());

        Element e2 = (Element) context.getBean("element2");
        System.out.println(e2.getDescription());*/

        Element c = (Element) context.getBean("candies");
        System.out.println(c.getDescription());


    }
}
