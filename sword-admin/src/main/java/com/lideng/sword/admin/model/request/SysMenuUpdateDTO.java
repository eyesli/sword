package com.lideng.sword.admin.model.request;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(notes = "权限标识")
    private String perms;

    private Integer type;

    private String icon;

    private Integer orderNum;

}