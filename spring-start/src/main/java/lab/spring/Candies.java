package lab.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

@Component("candies")
@SweetsQualifier
//@Qualifier("sweets")
public class Candies implements Element {

    //private String description;
    @Resource/*(name = "descriptions") // opcjonalne*/
    private List<String> descriptions;

/*    public void setDescription(String description) {
        this.description = description;
    }*/

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String getDescription() {
        return descriptions.toString();
    }

    public Candies() {
        System.out.println("candies constructor");
    }

/*    public Candies(String description) {
        System.out.println("candies constructor with parameter");

        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }*/

/*    @Override
    public String getDescription() {
        return ("box candies");
    }*/
}
