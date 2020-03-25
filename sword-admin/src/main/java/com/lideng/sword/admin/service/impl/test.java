package com.lideng.sword.admin.service.impl;
import java.util.Date;

import com.lideng.sword.admin.dao.SysRoleMapper;
import com.lideng.sword.admin.dao.SysRoleMenuMapper;
import com.lideng.sword.admin.model.entity.SysRoleMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author lideng
 * @date 2019/9/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Test
    public void getHello()  {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.opsForValue().set("1", "lideng");
//      //  Boolean key1 = template.hasKey("1");
//       // Object key = template.opsForValue().get("key");
//
//       // System.out.println(key1);
    }
}