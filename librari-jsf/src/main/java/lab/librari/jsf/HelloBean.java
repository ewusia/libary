package lab.librari.jsf;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "helloBean")
@ApplicationScoped
public class HelloBean {

    //POJO = Plain Old Java Object == Java Bean

    private int count;

    public int getCount() {
        return ++count;
    }

    public String getHelloMessage() {
        return "Hey Joe!";
    }
}
