package com.lideng.sword.admin.repository;


import com.lideng.sword.admin.model.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * @author lideng
 */
@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu,String>, JpaSpecificationExecutor<SysMenu> {



}
