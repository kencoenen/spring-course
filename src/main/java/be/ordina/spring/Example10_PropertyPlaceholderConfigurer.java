package be.ordina.spring;

import be.ordina.spring.service.EmailService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example10_PropertyPlaceholderConfigurer {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-default-property.xml");

        // We ask the bean created by Spring
        EmailService emailService = context.getBean(EmailService.class);
        emailService.sendMessage("Hi Ordina with EmailService and default recipient!", null);

        context.registerShutdownHook();
    }
}
