package com.lideng.sword.admin.model.request;


import lombok.Data;

/**
 *
 * @author lideng
 * @date 2019/10/08
 */
@Data
public class SysMenuUpdateDTO {

    private String id;

    private String name;

    private String url;

    private String perms;

    private Integer type;

    private String icon;

    private Integer orderNum;

}