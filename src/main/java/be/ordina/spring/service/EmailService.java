package be.ordina.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Default Spring bean name is <code>emailService</code>.
 *
 * @author Ken Coenen
 */
@Service
public class EmailService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private String footer;

    @Override
    public boolean sendMessage(String msg, String receiver) {
        logger.info("Email message sent to {} with Message '{} {}'", receiver, msg, footer);
        return true;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getFooter() {
        return footer;
    }
}