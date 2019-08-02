package lab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Primary
@PropertySource("lab.properties")
public class Meal implements Element {

    //@Autowired
    @Value("${meal.name}")
    //@Value("#{candies.description}")
    private String decription = "ogorkowa i schabowy";

   /* @Autowired
    Environment env;*/

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public String getDescription() {
        return decription;
        //return env.getProperty("meal.name");
    }
}
