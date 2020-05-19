package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.model.entity.SysUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author lideng
 */
@Repository
public interface UserRepository extends JpaRepository<SysUser,String>, JpaSpecificationExecutor<SysUser> {


    Optional<SysUser> findByName(String name);
}
