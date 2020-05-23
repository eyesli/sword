package com.lideng.sword.admin.repository;


import com.lideng.sword.admin.model.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author lideng
 */
@Repository
public interface RoleRepository extends JpaRepository<SysRole,String>, JpaSpecificationExecutor<SysRole> {


    Optional<SysRole>  findByName(String name);
    Optional<List<SysRole>>  findByDeptId(String id);

}
