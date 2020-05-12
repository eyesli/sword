package com.lideng.sword.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "admin_user")
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

    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",insertable = false, updatable = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private SysRole sysRole;

}