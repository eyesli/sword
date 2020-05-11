package com.lideng.sword.admin.jpa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "TEACHERS")
@EqualsAndHashCode
public class Teacher {

    @Id
    @GenericGenerator(name = "idWorker", strategy = "com.lideng.sword.common.utils.IdGenerator" )
    @GeneratedValue(generator = "idWorker")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "teachers")
    private List<User> users;
}