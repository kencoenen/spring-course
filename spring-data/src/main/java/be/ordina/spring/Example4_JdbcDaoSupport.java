package be.ordina.spring;

import be.ordina.spring.dao.MessageDao;
import be.ordina.spring.dao.MessageJdbcDaoSupportImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ken Coenen
 */
public class Example4_JdbcDaoSupport {
    private static final Logger logger = LoggerFactory.getLogger(Example4_JdbcDaoSupport.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MessageDao messageDao = context.getBean(MessageJdbcDaoSupportImpl.class);

        logger.info("{}", messageDao.searchMessages("Hello"));

        context.close();
    }
}
