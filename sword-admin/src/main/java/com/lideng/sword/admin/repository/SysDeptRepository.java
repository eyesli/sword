package com.lideng.sword.admin.repository;


import com.lideng.sword.admin.entity.SysDept;
import com.lideng.sword.admin.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author lideng
 */
public interface SysDeptRepository extends JpaRepository<SysDept,String>, JpaSpecificationExecutor<SysDept> {



}
