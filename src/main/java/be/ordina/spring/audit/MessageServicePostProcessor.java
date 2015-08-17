package be.ordina.spring.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Ken Coenen
 */
public class MessageServicePostProcessor implements BeanPostProcessor {
    private Logger logger = LoggerFactory.getLogger(MessageServicePostProcessor.class);
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Before initializing bean '{}'", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("After initializing bean '{}'", beanName);
        return bean;
    }
}
