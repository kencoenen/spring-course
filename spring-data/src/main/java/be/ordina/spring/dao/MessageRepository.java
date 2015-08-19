package be.ordina.spring.dao;

import be.ordina.spring.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ken Coenen
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
