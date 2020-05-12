package com.lideng.sword.admin.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

@Entity
@Getter
@Setter
@Table(name = "TEACHERS")
@EqualsAndHashCode
@Audited
public class Teacher {

    @Id
    @GenericGenerator(name = "idWorker", strategy = "com.lideng.sword.common.utils.IdGenerator" )
    @GeneratedValue(generator = "idWorker")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "teachers")
    @Audited(targetAuditMode = NOT_AUDITED)
    private List<User> users;
}