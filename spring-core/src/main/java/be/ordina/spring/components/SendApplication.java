package be.ordina.spring.components;

import be.ordina.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/**
 * @author Ken Coenen
 */
@Component
public class SendApplication {
    /**
     * We do not know which {@link be.ordina.spring.service.MessageService} we're using.
     */
    private MessageService messageService;

    public boolean processMessage(String msg, String rec){
        return messageService.sendMessage(msg, rec);
    }

    @Autowired
    @Required
    //@Qualifier("textMessageService")
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
