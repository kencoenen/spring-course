package be.ordina.spring.dao;

import be.ordina.spring.domain.Message;

/**
 * @author Ken Coenen
 */
public interface MessageDao {
    public Message getMessage(Long id);

    public int getCount();
}
