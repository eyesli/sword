package com.lideng.sword.admin.repository;


import com.lideng.sword.admin.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;


/**
 * @author lideng
 */
public interface RoleRepository extends JpaRepository<SysRole,String>, JpaSpecificationExecutor<SysRole> {


    Optional<SysRole>  findByName(String name);

}
