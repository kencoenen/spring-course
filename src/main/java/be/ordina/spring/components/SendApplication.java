package be.ordina.spring.components;

import be.ordina.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ken Coenen
 */
@Component
public class SendApplication {
    @Autowired
    private MessageService messageService;

    public boolean processMessage(String msg, String rec){
        return messageService.sendMessage(msg, rec);
    }
}
