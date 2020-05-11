package com.lideng.sword.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysUserRole {

    private String id;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Integer version;

    private String userId;

    private String roleId;

}