package com.lideng.sword.admin.event;

import com.lideng.sword.admin.model.entity.SysUser;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author lideng
 */
@Component
public class UserEventListener implements ApplicationListener<UserEvent> {
    @Override
    @Async
    //项目用的这种做的日志

    public void onApplicationEvent(UserEvent userevent) {
        // 把事件中的信息获取到
        SysUser user = userevent.getUser();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等
        System.out.println("用户名：" + user.getName());
        System.out.println("密码：" + user.getPassword());

    }
}
