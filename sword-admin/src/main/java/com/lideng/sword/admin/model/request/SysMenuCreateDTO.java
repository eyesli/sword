package com.lideng.sword.admin.model.request;

import lombok.Data;

import java.util.List;

/**
 *
 * @author lideng
 * @date 2019/10/08
 */
@Data
public class SysMenuCreateDTO  {

    private String parentId;

    private String name;

    private String url;

    private String perms;

    private Integer type;

    private String icon;

    private Integer orderNum;

}