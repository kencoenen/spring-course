package be.ordina.spring;

import be.ordina.spring.service.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example7_Collections {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context-collections.xml");

        // We ask the bean created by Spring
        EmailService emailService = context.getBean(EmailService.class);
        emailService.sendMessage("Hi Ordina with injected Collection!", "info@ordina.be");
    }
}
