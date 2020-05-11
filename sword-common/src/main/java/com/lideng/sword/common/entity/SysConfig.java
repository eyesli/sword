package com.lideng.sword.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lideng
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysConfig extends BaseModel {

    private String value;

    private String label;

    private String type;

    private String description;

    private String sort;

    private String remarks;

    /**
     * false代表删除，true代表正常
     */
    private boolean delFlag;

}