package com.lideng.sword.admin.config.springInterface;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * InstantiationAwareBeanPostProcessorImpl
 *
 * @author lideng
 * @date 2021/6/27 下午4:36
 **/
//在Bean实例化前后做一些操作。
@Component
public class InstantiationAwareBeanPostProcessorImpl implements InstantiationAwareBeanPostProcessor {

//    执行顺序为：先实例化，在初始化。即
//    postProcessBeforeInstantiation
//    ->postProcessAfterInstantiation
//    ->postProcessPropertyValues
//    ->postProcessBeforeInitialization
//    ->@PostConstruct注解修饰的方法（如果有的话）
//    ->postProcessAfterInitialization。

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return pvs;
    }
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
