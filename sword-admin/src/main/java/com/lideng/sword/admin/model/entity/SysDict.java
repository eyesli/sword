package com.lideng.sword.admin.model.entity;

import com.lideng.sword.admin.model.entity.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@Entity
@Getter
@Setter
@Table(name = "sys_dict")
@EntityListeners(AuditingEntityListener.class)
public class SysDict extends BaseModel {

    private String value;

    private String label;

    private String type;

    private String description;

    private String sort;

    private String remarks;


}