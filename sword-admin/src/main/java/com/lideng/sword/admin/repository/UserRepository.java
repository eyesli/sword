package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.jpa.User;
import com.lideng.sword.admin.jpa.UserDTO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * @author lideng
 */
public interface UserRepository<T> extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    List<T> findUserById(Long id, Class<T> tClass);
	
}
