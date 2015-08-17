package be.ordina.spring;

import be.ordina.spring.service.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example3_ApplicationContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        // We ask the bean created by Spring
        EmailService emailService = (EmailService) context.getBean("emailService");
        emailService.sendMessage("Hi Ordina with EmailService managed by Spring!", "info@ordina.be");
    }
}
