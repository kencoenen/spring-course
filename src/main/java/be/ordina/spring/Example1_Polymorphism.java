package be.ordina.spring;

import be.ordina.spring.components.SendApplication;
import be.ordina.spring.service.EmailService;
import be.ordina.spring.service.MessageService;
import be.ordina.spring.service.TextService;

/**
 * @author Ken Coenen
 */
public class Example1_Polymorphism {
    public static void main(String[] args) {
        // Without polymorphism
        new EmailService().sendMessage("Hi Ordina with EmailService implementation!", "info@ordina.be");
        new TextService().sendMessage("Hi Ordina with TextService implementation!", "0123456789");

        // With polymorphism but with knowledge of which service you're using (no inversion of control!)
        MessageService service = new EmailService();
        service.sendMessage("Hi Ordina with MessageService interface!", "info@ordina.be");

        // Inversion of Control in the SendApplication class (it does not create the dependency itself)
        SendApplication app = new SendApplication();
        app.setMessageService(service);
        app.processMessage("Hi Ordina through SendApplication!", "info@ordina.be");
    }
}
