package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author lideng
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

	
}
