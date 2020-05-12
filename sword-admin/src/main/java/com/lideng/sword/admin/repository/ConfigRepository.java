package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.entity.SysConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


/**
 * @author lideng
 */
public interface ConfigRepository extends JpaRepository<SysConfig,String>, JpaSpecificationExecutor<SysConfig> {

    List<SysConfig> findByLabel(String label);

}
