package com.lideng.sword.admin.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@Entity
@Getter
@Setter
@Table(name = "sys_menu")
public class SysMenu extends BaseModel {


    private String name;

    private String url;

    private String parentId;


    /**
     * 权限标识
     */
    private String perms;

    @Enumerated(EnumType.ORDINAL)
    private MenuType type;

    private String icon;

    private Integer orderNum;


    @Transient
    private String parentName;

    @Transient
    private Integer level;

    @Transient
    private List<SysMenu> children;

    @Transient
    private String title;

    @Transient
    private String key;

    @Transient
    private String value;

}