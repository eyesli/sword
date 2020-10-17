package com.lideng.sword.admin.model.entity;

import com.lideng.sword.admin.model.entity.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * @author lideng
 */
@Entity
@Getter
@Setter
@Table(name = "sys_config")
public class SysConfig extends BaseModel {

    private String value;

    private String label;

    private String type;

    private String description;

    private String sort;

    private String remarks;

}