package com.lideng.sword.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * @author lideng
 */
@Entity
@Getter
@Setter
@Table(name = "admin_config")
@EntityListeners(AuditingEntityListener.class)
public class SysConfig extends BaseModel {

    private String value;

    private String label;

    private String type;

    private String description;

    private String sort;

    private String remarks;


}