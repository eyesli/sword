package com.lideng.sword.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysMenu extends BaseModel {

    private String parentId;

    private String name;

    private String url;

    /**
     * 权限标识
     */
    private String perms;

    private Integer type;

    private String icon;

    private Integer orderNum;

    private boolean delFlag;

    /**
     * 非数据库字段
     */
    private String parentName;
    /**
     * 非数据库字段
     */
    private Integer level;

    /**
     * 非数据库字段
     */
    private List<SysMenu> children;

}