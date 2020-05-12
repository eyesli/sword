package com.lideng.sword.admin.repository;


import com.lideng.sword.admin.model.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author lideng
 */
public interface SysMenuRepository extends JpaRepository<SysMenu,String>, JpaSpecificationExecutor<SysMenu> {



}
