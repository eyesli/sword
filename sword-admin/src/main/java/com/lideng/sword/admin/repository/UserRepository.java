package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.jpa.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;


/**
 * @author lideng
 */
public interface UserRepository extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

   // Page<List<T>>findUserById(String id, Class<T> tClass, Pageable var2);

}
