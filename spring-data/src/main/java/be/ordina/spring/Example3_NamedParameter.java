package be.ordina.spring;

import be.ordina.spring.dao.MessageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example3_NamedParameter {
    private static final Logger logger = LoggerFactory.getLogger(Example3_NamedParameter.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MessageDao messageDao = context.getBean(MessageDao.class);

        logger.info("{}", messageDao.searchMessages("Hello"));

        context.close();
    }
}
