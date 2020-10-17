package com.lideng.sword.admin.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 常量管理
 * @author lideng
 * @date July 30, 2019
 */
@Getter
@AllArgsConstructor
public enum SysConstants {

    /**
     * 系统管理员
     */
    ADMIN( "admin"),
    USERNAME("username");



    private String value;

}
