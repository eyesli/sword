package com.lideng.sword.admin.repository;


import com.lideng.sword.admin.model.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author lideng
 */
@Repository
public interface RoleRepository extends JpaRepository<SysRole,String>, JpaSpecificationExecutor<SysRole> {


    Optional<SysRole>  findByName(String name);

    @Modifying
    @Query(value = "insert into a(a) values(?1)",nativeQuery = true)
    int a(int i);

    @Modifying
    @Query(value = "insert into b(b) values(?1)",nativeQuery = true)
    int b(int i);


    Optional<List<SysRole>>  findByDeptId(String id);

}
