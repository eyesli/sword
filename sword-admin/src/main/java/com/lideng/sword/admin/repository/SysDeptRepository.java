package com.lideng.sword.admin.repository;


import com.lideng.sword.admin.model.entity.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * @author lideng
 */
@Repository
public interface SysDeptRepository extends JpaRepository<SysDept,String>, JpaSpecificationExecutor<SysDept> {



}
