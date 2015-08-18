package be.ordina.spring;

import be.ordina.spring.dao.MessageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example2_SpringJDBC {
    private static final Logger logger = LoggerFactory.getLogger(Example2_SpringJDBC.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MessageDao messageDao = context.getBean(MessageDao.class);

        logger.info("{}", messageDao.getMessage(1L));
        logger.info("{} messages found", messageDao.getCount());

        context.close();
    }
}
