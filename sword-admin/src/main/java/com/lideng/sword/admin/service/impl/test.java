package com.lideng.sword.admin.service.impl;

import com.lideng.sword.admin.model.entity.DelStatus;
import com.lideng.sword.admin.model.entity.SysRole;
import com.lideng.sword.admin.model.entity.SysUser;
import com.lideng.sword.admin.repository.RoleRepository;
import com.lideng.sword.common.utils.IdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lideng
 * @date 2019/9/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {


    @Autowired
    com.lideng.sword.admin.repository.UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    IdWorker idWorker;
    @Test
    public void getHello()  {

        SysRole sysRoles = new SysRole();
        sysRoles.setName("经理2");
        sysRoles.setDelFlag(DelStatus.NORMAL);
       // sysRoles.setDescription("2一般般权限");
        sysRoles.setVersion(0);
//        roleRepository.save(sysRoles);

        SysUser sysUser1 = userRepository.findById("1260081237888995328").get();

        SysRole sysRole = sysUser1.getSysRole();
        System.out.println(sysRole);
        SysUser sysUser = new SysUser();
        sysUser.setName("sysRoles2");
        sysUser.setVersion(0);
      //  userRepository.save(sysUser);



//        SysRoles sysRoles = new SysRoles();
//        sysRoles.setName("lideng");
//        sysRoles.setDelFlag(DelStatus.NORMAL);
//        sysRoles.setDescription("最高权限");
//        sysRoles.setVersion(0);
//        teacherRepository.save(sysRoles);
//        User user=new User();
//
//        User user1=new User();
//
//        User user2=new User();
//
//        User user3=new User();
//
//
//
//        HashSet<Teacher> set = new HashSet<>();
//       Teacher teacher = new Teacher();
//         List<User> list= new ArrayList<>() ;
//         teacher.setName("Tea li12356");
//      set.add(teacher);
//
//      user.setTeachers(set);
//        user.setName("zhangfei12356");
//
//        user1.setTeachers(set);
//        user1.setName("zhaoyun12356");
//
//        user2.setTeachers(set);
//        user2.setName("liubei12356");
//
//        user3.setTeachers(set);
//        user3.setName("lvbu12356");
//
//        list.add(user);
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        userRepository.saveAll(list);

       // teacherRepository.save(teacher);
//
//        Object userById = userRepository.findUserById(1L, UserDTO.class);
//        System.out.println(userById);

    }
}