package com.sanef.api.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;


@SuppressWarnings("unchecked")
@Component
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext CONTEXT;


    /**
     * This method is called from within the ApplicationContext once it is done starting up, it will stick a reference
     * to itself into this bean.
     * 
     * 
     * @param context
     *            a reference to the ApplicationContext.
     */
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringApplicationContext.CONTEXT = context;
    }


    /**
     * This is about the same as context.getBean("beanName"), except it has its own static handle to the Spring context,
     * so calling this method statically will give access to the beans by name in the Spring application context. As in
     * the context.getBean("beanName") call, the caller must cast to the appropriate target class. If the bean does not
     * exist, then a Runtime error will be thrown.
     * 
     * @param <T>
     * 
     * @param beanName
     *            the name of the bean to get.
     * @return an Object reference to the named bean.
     */
    public static <T> T getBean(String beanName) {
        return (T) SpringApplicationContext.CONTEXT.getBean(beanName);
    }


    public static <T> Map<String, T> getBeans(Class<T> klass) {
        return SpringApplicationContext.CONTEXT.getBeansOfType(klass);
    }
    
    public static <T> T registerSingleton(Class<T> klass,String beanName) {
    	ConfigurableListableBeanFactory beanFactory = ((ConfigurableApplicationContext) CONTEXT).getBeanFactory();
    	beanFactory.registerSingleton(klass.getCanonicalName(), beanName);
        return getBean(beanName);
    }
    
    
    
}
