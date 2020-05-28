package com.lideng.sword.admin.model.entity;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.List;


/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@Entity
@Getter
@Setter
@Table(name = "sys_dept")
@EntityListeners(AuditingEntityListener.class)
public class SysDept extends BaseModel {

    private String name;

    private String parentId;

    private Integer orderNum;


    /**
     * 这三个字段纯粹是为了偷懒，前端的UI框架需要这三个字段，为了方便，就直接塞进去了
     */
    @Transient
    private String title;

    @Transient
    private String key;

    @Transient
    private String value;



    @Transient
    private Integer level;

    @Transient
    private List<SysDept> children;

    @Transient
    private String parentName;
}