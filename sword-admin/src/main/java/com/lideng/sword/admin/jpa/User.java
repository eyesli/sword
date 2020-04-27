package com.lideng.sword.admin.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "User")
public class User{
    @Id
    @GeneratedValue
    //@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
	/**
     * 多对多
     */
    @JsonIgnoreProperties(value = { "users" })
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "TEACHER_USER_RELATION",
            joinColumns = 
            @JoinColumn(name = "UserId",referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "TeacherId",referencedColumnName = "id")
    )
    private Set<Teacher> teachers;
}