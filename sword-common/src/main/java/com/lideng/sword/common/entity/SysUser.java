package com.lideng.sword.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysUser extends BaseModel {

    private String name;

    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    /**
     * 账号的状态0：禁用 1：正常
     */
    private boolean status;

    private String deptId;

    private boolean delFlag;

    /**
     * 非数据库字段
     */
    private String deptName;
    /**
     * 非数据库字段
     */
    private String roleNames;
    /**
     * 非数据库字段
     */
    private List<SysUserRole> userRoles = new ArrayList<>();



}