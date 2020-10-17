package com.lideng.sword.admin.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
//@NamedEntityGraph(name = "MerchantOtherEntity", attributeNodes = {@NamedAttributeNode("merchantStatusEntity")})

//@EntityGraph(value = "MerchantOtherEntity", type = EntityGraph.EntityGraphType.FETCH)

public class User{
    @Id
    @GenericGenerator(name = "idWorker", strategy = "com.lideng.sword.common.utils.IdGenerator" )
    @GeneratedValue(generator = "idWorker")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;


    @Column(name = "CREATE_DT")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;

    @Column(name = "create_by")
    @CreatedBy
    private String createBy;

    @Column(name = "last_update_by")
    @LastModifiedBy
    private String lastUpdateBy;


    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "UPDATE_DT")
    private Date updateDate;


	/**
     * 多对多
     */
   // @JsonIgnore

   // @JsonIgnoreProperties(value = { "users" })
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "TEACHER_USER_RELATIONS",
            joinColumns = 
            @JoinColumn(name = "UserId",referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "TeacherId",referencedColumnName = "id")
    )
    private Set<Teacher> teachers;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "MT_BUSINESS_TYPE_ID", nullable = true, insertable = false, updatable = false)
//    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
//    private BusinessTypeEntity businessTypeEntity;


//    @PrePersist
//    public void onPrePersist() {
//        audit("INSERT");
//    }
//
//    @PreUpdate
//    public void onPreUpdate() {
//        audit("UPDATE");
//    }
//
//    @PreRemove
//    public void onPreRemove() {
//        audit("DELETE");
//    }
//
//    private void audit(String operation) {
//        setOperation(operation);
//        setTimestamp((new Date()).getTime());
//    }
}