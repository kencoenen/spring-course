package be.ordina.spring;

import be.ordina.spring.components.SendApplication;
import be.ordina.spring.config.MyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example2_AnnotationConfig {
    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        // SendApplication does not know which implementation of MessageService it is using.
        // This is called Inversion of Control or Dependency Injection
        SendApplication app = context.getBean(SendApplication.class);
        app.processMessage("Hi Ordina!", "info@ordina.be");

        context.close();
    }
}
