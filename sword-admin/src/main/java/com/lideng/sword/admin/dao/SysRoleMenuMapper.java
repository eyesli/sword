package com.lideng.sword.admin.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
public interface SysRoleMenuMapper {

	@Insert("insert into a(a) value (#{a})")
	void a(int a);
    @Insert("insert into b(b) value (#{b})")
    void b(int b);

    @Select("select a from a where a=(#{a)")
    String sa(int a);

    @Select("select b from b where b=(#{b)")
    String sb(int b);

}