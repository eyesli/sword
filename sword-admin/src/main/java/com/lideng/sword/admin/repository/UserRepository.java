package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.entity.SysUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



/**
 * @author lideng
 */
public interface UserRepository extends JpaRepository<SysUser,String>, JpaSpecificationExecutor<SysUser> {


}
