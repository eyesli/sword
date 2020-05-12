package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.entity.SysMenu;
import com.lideng.sword.admin.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


/**
 * @author lideng
 */
public interface MenuRepository extends JpaRepository<SysMenu,String>, JpaSpecificationExecutor<SysMenu> {

    List<SysMenu> findByUserName(String name);
}
