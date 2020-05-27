package com.lideng.sword.admin.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",insertable = false, updatable = false,foreignKey = @ForeignKey(name = "none" ,value = ConstraintMode.NO_CONSTRAINT))
    private SysRole sysRole;


    /*
    这个注解是json序列化的时候会出现问题，懒加载 的时候会出现问题，但是我这里写的是立即加载还是还会有错
    加这个注解就序列化正常，跟懒加载有关系，没深入看
     */
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id",insertable = false, updatable = false)
    private SysDept sysDept;
}