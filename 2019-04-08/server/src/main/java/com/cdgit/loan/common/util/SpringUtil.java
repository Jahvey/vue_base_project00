package com.cdgit.loan.common.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware{

	private static Logger logger = Logger.getLogger(SpringUtil.class);

    private static ApplicationContext applicationContext; 
	
    public SpringUtil() {
    }
    
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		if(SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext=applicationContext;
		}
		logger.info("ApplicationContext配置成功,applicationContext对象："+SpringUtil.applicationContext);
	}

	public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
	
	public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name,Class<T> clazz) {
        return getApplicationContext().getBean(name,clazz);
    }
	
}
