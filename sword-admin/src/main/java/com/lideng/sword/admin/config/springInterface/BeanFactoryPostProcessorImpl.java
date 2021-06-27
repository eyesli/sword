package com.lideng.sword.admin.config.springInterface;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * BeanFactoryPostProcessorImpl
 *
 * @author lideng
 * @date 2021/6/27 下午5:01
 **/
@Component
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {

//    spring容器初始化时，从资源中读取到bean的相关定义后，
//    保存在beanFactory的成员变量中（参考DefaultListableBeanFactory类的成员变量beanDefinitionMap），
//    在实例化bean的操作就是依据这些bean的定义来做的，
//    而在实例化之前，spring允许我们通过自定义扩展来改变bean的定义，定义一旦变了，后面的实例也就变了，
//    而beanFactory后置处理器，即BeanFactoryPostProcessor就是用来改变bean定义的；

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition abstractBeanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("calculateService");

        MutablePropertyValues pv =  abstractBeanDefinition.getPropertyValues();
        pv.addPropertyValue("desc", "Desc is changed from bean factory post processor");
        abstractBeanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);

    }
}
