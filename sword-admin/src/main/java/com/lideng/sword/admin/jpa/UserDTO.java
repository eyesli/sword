package com.lideng.sword.admin.jpa;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author lideng
 */
@Getter
@Setter
@ToString
@AllArgsConstructor

public class UserDTO {

    private String name;

}