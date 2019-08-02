package lab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Box {

    @Autowired
    //@SweetsQualifier
    //@Qualifier("sweets")
    private Element element;

    public Box() {
        System.out.println("box constructor");
    }

    public Box(Element element) {
        System.out.println("box constructor with parameter");

        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String describeContent() {
        return "box content is: " + element.getDescription();
    }
}
