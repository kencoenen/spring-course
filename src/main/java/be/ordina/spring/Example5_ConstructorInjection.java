package be.ordina.spring;

import be.ordina.spring.service.EmailService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example5_ConstructorInjection {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-constructor-injection.xml");

        // We ask the bean created by Spring
        EmailService emailService = (EmailService) context.getBean("emailService");
        emailService.sendMessage("Hi Ordina with EmailService managed by Spring!", "info@ordina.be");

        context.registerShutdownHook();
    }
}
