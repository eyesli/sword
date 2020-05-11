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
public class SysDict extends BaseModel {

    private String value;

    private String label;

    private String type;

    private String description;

    private String sort;

    private String remarks;

    private boolean delFlag;

}