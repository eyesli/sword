package com.lideng.sword.admin.repository;


import com.lideng.sword.admin.entity.SysMenu;
import com.lideng.sword.admin.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author lideng
 */
public interface SysMenuRepository extends JpaRepository<SysMenu,String>, JpaSpecificationExecutor<SysMenu> {



}
