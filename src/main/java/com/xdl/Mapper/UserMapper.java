package com.xdl.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xdl.bean.AddUserCase;
import com.xdl.bean.LoginCase;
import com.xdl.bean.User;


public interface UserMapper {
	

	@Select("select * from xdl_user")
	public List<User> getUsers();
	
	@Select("select count(*) from xdl_user where id=#{id}")
	public Integer getUserById(@Param("id")Integer id);
	
	@Insert("insert into xdl_user(name,age,sex) values(#{name},#{age},#{sex})")
	public Integer addUser(@Param("name")String name,@Param("age")Integer age,@Param("sex")String sex);

	@Update("update xdl_user set sex=#{sex} where id=#{id}")
	public Integer updateUser(@Param("sex")String sex,@Param("id")Integer id);

	
	//测试用例
	
	@Select("select* from logincase where id=#{id}")
	public LoginCase loginCase(@Param("id")Integer id);
	
	@Select("select* from addusercase where id=#{id}")
	public AddUserCase addUserCase(@Param("id")Integer id);

	

}
