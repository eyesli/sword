package com.lideng.sword.admin.model.entity;


import lombok.Getter;
import lombok.Setter;


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
public class SysRole  extends BaseModel {


    private String name;

    @Column(name="description")
    private String description;

    @Column(name="dept_id")
    private String deptId;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SYS_ROLE_MENU_RELATIONS",
            joinColumns =
            @JoinColumn(name = "role_id",referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "menu_id",referencedColumnName = "id")
    )
    private List<SysMenu> sysMenu;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "dept_id",insertable = false, updatable = false)
    private SysDept sysDept;

}