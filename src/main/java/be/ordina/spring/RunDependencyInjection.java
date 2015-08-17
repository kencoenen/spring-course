package be.ordina.spring;

import be.ordina.spring.components.SendApplication;
import be.ordina.spring.config.MyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Ken Coenen
 */
public class RunDependencyInjection {
    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        SendApplication app = context.getBean(SendApplication.class);

        app.processMessage("Hi Ordina!", "info@ordina.be");

        //close the context
        context.close();
    }
}
