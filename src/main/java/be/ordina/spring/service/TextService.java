package be.ordina.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Ken Coenen
 */
@Service
public class TextService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(TextService.class);

    @Override
    public boolean sendMessage(String msg, String receiver) {
        logger.info("Text message sent to {} with Message '{}'", receiver, msg);
        return true;
    }
}
