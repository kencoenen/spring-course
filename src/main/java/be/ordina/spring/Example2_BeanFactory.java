package be.ordina.spring;

import be.ordina.spring.service.EmailService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author Ken Coenen
 */
public class Example2_BeanFactory {
    public static void main(String[] args) {
        // We have to construct a {@link BeanFactory} based on a configuration file
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/context.xml"));

        // We ask the bean created by Spring
        EmailService emailService = (EmailService) factory.getBean("emailService");
        emailService.sendMessage("Hi Ordina with EmailService managed by Spring!", "info@ordina.be");
    }
}
