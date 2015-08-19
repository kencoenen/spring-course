package be.ordina.spring;

import be.ordina.spring.config.SpringDataConfig;
import be.ordina.spring.dao.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example5_SpringData {
    private static final Logger logger = LoggerFactory.getLogger(Example5_SpringData.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);
        MessageRepository repository = context.getBean(MessageRepository.class);

        repository.findAll().stream().forEach(m -> logger.info(m.toString()));

        context.close();
    }
}
