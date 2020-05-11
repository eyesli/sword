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
public class SysDept extends BaseModel {

    private String name;

    private String parentId;

    private Integer orderNum;

    private boolean delFlag;
    /**
     * 非数据库字段
     */
    private List<SysDept> children;
    /**
     * 非数据库字段
     */
    private String parentName;
    /**
     * 非数据库字段
     */
    private Integer level;
}