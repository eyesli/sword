package com.lideng.sword.admin.event;

import com.lideng.sword.admin.model.entity.SysUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author lideng
 */
@Getter
@Setter
public class UserEvent extends ApplicationEvent {

    private SysUser user;

    public UserEvent(Object source, SysUser user) {
        super(source);
        this.user = user;
    }


}
