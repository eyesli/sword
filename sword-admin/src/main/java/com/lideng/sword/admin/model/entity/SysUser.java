package com.lideng.sword.admin.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@Entity
@Getter
@Setter
@Table(name = "sys_user")
public class SysUser extends BaseModel {

    private String name;

    private String nickName;

    private String avatar;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "dept_id")
    private String deptId;

    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;

   // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",insertable = false, updatable = false,foreignKey = @ForeignKey(name = "none" ,value = ConstraintMode.NO_CONSTRAINT))
    private SysRole sysRole;


    /*
        hibernate对象懒加载，json序列化失败,因为懒加载这个对象属性只是一个代理对象，如果json直接当作一个存在的属性去序列化就会出现错误
        在使用hibernate的时候，查询数据库后产生的实体类是个代理类，这时候转换JSON会报错
     */
   // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id",insertable = false, updatable = false)
    private SysDept sysDept;
}