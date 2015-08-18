package be.ordina.spring.service;

/**
 * Allow polymorphism by creating an interface of the message service so that the implementation details
 * are hidden for using classes.
 *
 * @author Ken Coenen
 */
public interface MessageService {
    boolean sendMessage(String msg, String receiver);
}