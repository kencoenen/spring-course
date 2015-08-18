package be.ordina.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example11_Required {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("context-required.xml");
    }
}
