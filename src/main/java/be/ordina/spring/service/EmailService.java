package be.ordina.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Ken Coenen
 */
@Service("scannedEmailService")
public class EmailService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Override
    public boolean sendMessage(String msg, String receiver) {
        logger.info("Email message sent to {} with Message '{}'", receiver, msg);
        return true;
    }
}