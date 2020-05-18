package com.lideng.sword.admin.service.impl;
import java.util.*;

import com.lideng.sword.admin.dao.SysRoleMapper;
import com.lideng.sword.admin.dao.SysRoleMenuMapper;
import com.lideng.sword.admin.jpa.Teacher;
import com.lideng.sword.admin.jpa.User;

import com.lideng.sword.common.utils.IdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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

//    @Autowired
//    com.lideng.sword.admin.repository.UserRepository userRepository;
//    @Autowired
//    TeacherRepository teacherRepository;

    @Autowired
    IdWorker idWorker;
    @Test
    public void getHello()  {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx == null) {
            System.out.println(1);
        }
        if (ctx.getAuthentication() == null) {
            System.out.println(12);
        }else{
            String loginUserName = ctx.getAuthentication().getName();
            System.out.println(loginUserName);
        }

        User user=new User();

        User user1=new User();

        User user2=new User();

        User user3=new User();



        HashSet<Teacher> set = new HashSet<>();
       Teacher teacher = new Teacher();
         List<User> list= new ArrayList<>() ;
         teacher.setName("Tea li12356");
      set.add(teacher);

      user.setTeachers(set);
        user.setName("zhangfei12356");

        user1.setTeachers(set);
        user1.setName("zhaoyun12356");

        user2.setTeachers(set);
        user2.setName("liubei12356");

        user3.setTeachers(set);
        user3.setName("lvbu12356");

        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
       // userRepository.saveAll(list);

       // teacherRepository.save(teacher);
//
//        Object userById = userRepository.findUserById(1L, UserDTO.class);
//        System.out.println(userById);

    }}
