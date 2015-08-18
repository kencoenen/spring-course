package be.ordina.spring;

import be.ordina.spring.components.SendApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * For this example to work, uncomment <code>//@Qualifier("textMessageService")</code> in
 * {@link be.ordina.spring.components.SendApplication}.
 *
 * @author Ken Coenen
 */
public class Example12_Autowired {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-autowire-annotation.xml");

        // We ask the bean created by Spring
        SendApplication app = context.getBean(SendApplication.class);
        app.processMessage("Hi Ordina with autowired TextService!", "info@ordina.be");

        context.registerShutdownHook();
    }
}
