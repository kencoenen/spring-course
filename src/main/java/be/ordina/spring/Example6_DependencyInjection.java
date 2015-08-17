package be.ordina.spring;

import be.ordina.spring.components.SendApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example6_DependencyInjection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context-dependency-injection.xml");

        // We ask the bean created by Spring
        SendApplication app = context.getBean(SendApplication.class);
        app.processMessage("Hi Ordina with injected EmailService!", "info@ordina.be");
    }
}
