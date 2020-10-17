package com.lideng.sword.admin.dao;


import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface SysRoleMenuMapper {

	@Insert("insert into a(a) value (#{a})")
	void a(int a);
    @Insert("insert into b(b) value (#{b})")
    void b(int b);
}