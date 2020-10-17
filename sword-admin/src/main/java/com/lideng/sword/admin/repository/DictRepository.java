package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.model.entity.SysDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author lideng
 */
@Repository
public interface DictRepository extends JpaRepository<SysDict,String>, JpaSpecificationExecutor<SysDict> {


    List<SysDict> findByLabel(String label);
}
