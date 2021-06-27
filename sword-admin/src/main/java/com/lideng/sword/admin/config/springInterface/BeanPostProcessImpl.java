package com.lideng.sword.admin.config.springInterface;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcess
 *
 * @author lideng
 * @date 2021/6/27 下午4:27
 **/
@Component
public class BeanPostProcessImpl implements BeanPostProcessor {

//    在每个bean初始化成前后做操作。
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization"+bean);
        return bean;
    }
}
