package com.gyhl.test.webSocket.config;

import javax.websocket.server.ServerEndpointConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * @Author：JCccc
 * @Description：
 * @Date： created in 15:56 2019/5/13
 */
public class MyEndpointConfigure extends ServerEndpointConfig.Configurator implements ApplicationContextAware {
    private static volatile BeanFactory context;
 
    @Override
    public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
        return context.getBean(clazz);
    }
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MyEndpointConfigure.context = applicationContext;
    }
}
