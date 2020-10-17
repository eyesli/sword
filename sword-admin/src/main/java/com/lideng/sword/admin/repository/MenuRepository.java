package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.model.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author lideng
 */
@Repository
public interface MenuRepository extends JpaRepository<SysMenu,String>, JpaSpecificationExecutor<SysMenu> {

    List<SysMenu> findByName(String name);
}
