package com.lideng.sword.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysRoleMenu extends BaseModel {

    private String roleId;

    private String menuId;

}