package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.model.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


/**
 * @author lideng
 */
public interface MenuRepository extends JpaRepository<SysMenu,String>, JpaSpecificationExecutor<SysMenu> {

    List<SysMenu> findByName(String name);
}
