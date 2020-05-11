package com.lideng.sword.admin.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
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

    @JsonIgnoreProperties(value = { "users" })
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "TEACHER_USER_RELATIONS",
            joinColumns = 
            @JoinColumn(name = "UserId",referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "TeacherId",referencedColumnName = "id")
    )
    private Set<Teacher> teachers;


//    @PrePersist
//    protected void onCreate() {
//        createDate = new Date();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updateDate = new Date();
//    }
}