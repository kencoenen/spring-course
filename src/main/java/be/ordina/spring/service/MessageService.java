package be.ordina.spring.service;

/**
 * @author Ken Coenen
 */
public interface MessageService {
    boolean sendMessage(String msg, String receiver);
}