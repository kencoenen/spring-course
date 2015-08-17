package be.ordina.spring.service;

import org.springframework.stereotype.Service;

/**
 * @author Ken Coenen
 */
@Service("scannedEmailService")
public class EmailService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email Sent to " + rec + " with Message = '" + msg + "'");
        return true;
    }
}