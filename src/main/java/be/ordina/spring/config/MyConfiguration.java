package be.ordina.spring.config;

import be.ordina.spring.service.EmailService;
import be.ordina.spring.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ken Coenen
 */
@Configuration
@ComponentScan(value = {"be.ordina.spring"})
public class MyConfiguration {
    @Bean
    public MessageService messageService() {
        return new EmailService();
    }
}
