package com.lideng.sword.admin.repository;

import com.lideng.sword.admin.jpa.Teacher;
import com.lideng.sword.admin.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author lideng
 */
public interface TeacherRepository extends JpaRepository<Teacher, String> {

	
}
