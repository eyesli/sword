package com.lideng.sword.admin.jpa;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "TEACHER")
public class Teacher {

    @Id
    @GeneratedValue
   // @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "teachers")
    private List<User> users;
}