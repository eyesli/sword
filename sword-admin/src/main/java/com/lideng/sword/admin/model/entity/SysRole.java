package com.lideng.sword.admin.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lideng.sword.admin.model.entity.BaseModel;
import com.lideng.sword.admin.model.entity.SysDept;
import com.lideng.sword.admin.model.entity.SysMenu;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@Entity
@Getter
@Setter
@Table(name = "sys_role")
@EntityListeners(AuditingEntityListener.class)
public class SysRole  extends BaseModel {


    private String name;

    @Column(name="description")
    private String description;

    @Column(name="dept_id")
    private String deptId;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SYS_ROLE_MENU_RELATIONS",
            joinColumns =
            @JoinColumn(name = "role_id",referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "menu_id",referencedColumnName = "id")
    )
    private List<SysMenu> sysMenu;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JoinColumn(name = "dept_id",insertable = false, updatable = false)
    private SysDept sysDept;
}