package com.demoinaction.mybatis;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 从Spring容器中取得对象
 * @author weiyuan
 *
 */
@Component
public class SpringContextUtil implements ApplicationContextAware
         {

    private static ApplicationContext applicationContext; // Spring上下文对象.静态变量,可在任何代码任何地方任何时候中取出ApplicaitonContext. 

    
    Log log = LogFactory.getLog(SpringContextUtil.class);
    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     * 
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        log.debug(" com.hna.hka.rmc.common.util.SpringContextUtil setApplicationContext "+applicationContext);
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象
     * 
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

             public static      <T> T getBean(Class<T> zclass) throws BeansException {
                 return applicationContext.getBean(zclass);
             }
}