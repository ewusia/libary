package lab.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("lab.spring")
public class Config {

    @Bean
    public String getMealString(){
        return ("manakish");
    }
/*    @Bean("descriptions")
    public List<String> getCandiesList() {
        return Arrays.asList("lentilky", "mamba", "czekolada studnecka");
    }*/

    @Bean
    public List<String> descriptions() {
        return Arrays.asList("lentilky", "mamba", "czekolada studnecka");
    }


}
