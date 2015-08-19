package be.ordina.spring.dao;

import be.ordina.spring.domain.Message;

import java.util.List;

/**
 * @author Ken Coenen
 */
public interface MessageDao {
    public List<Message> getMessages();

    public Message getMessage(Long id);

    public int getCount();

    public List<Message> searchMessages(String text);
}
