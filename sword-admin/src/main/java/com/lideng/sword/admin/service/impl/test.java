package com.lideng.sword.admin.service.impl;
import java.util.*;

import com.lideng.sword.admin.dao.SysRoleMapper;
import com.lideng.sword.admin.dao.SysRoleMenuMapper;
import com.lideng.sword.admin.jpa.Teacher;
import com.lideng.sword.admin.jpa.User;
import com.lideng.sword.admin.jpa.UserDTO;
import com.lideng.sword.admin.model.entity.SysRoleMenu;
import com.lideng.sword.admin.repository.TeacherRepository;
import com.lideng.sword.admin.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lideng
 * @date 2019/9/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    com.lideng.sword.admin.repository.UserRepository userRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void getHello()  {
//
//        List<User> list=new ArrayList();
//        User user=new User();
//
//        user.setName("abcde");
//
//        list.add(user);
//        Teacher teacher = new Teacher();
//
//        teacher.setName("t7");
//
//        teacher.setUsers(list);


//        HashSet<Teacher> set = new HashSet<>();
//        set.add(teacher);
//        user.setTeachers(set);
//        userRepository.save(user);

       // teacherRepository.save(teacher);
//
//        Object userById = userRepository.findUserById(1L, UserDTO.class);
//        System.out.println(userById);

    }
}