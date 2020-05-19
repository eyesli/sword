package com.lideng.sword.admin.event;

import com.lideng.sword.admin.model.entity.SysUser;
import org.springframework.context.ApplicationEvent;

import com.lideng.sword.admin.service.impl.SysConfigServiceImpl;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component

public class WechatListener implements SmartApplicationListener {

    //设置监听优先级
    @Override
    public int getOrder() {
        return 1;
    }


    //监听器智能所在之一，能够根据事件类型动态监听
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == UserEvent.class;
    }

    //监听器智能所在之二，能够根据事件发布者类型动态监听
    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == SysConfigServiceImpl.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        UserEvent event = (UserEvent) applicationEvent;
        //发送短信
        SysUser user = event.getUser();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等
        System.out.println("用户名1：" + user.getName());
        System.out.println("密码1：" + user.getPassword());
    }
}

