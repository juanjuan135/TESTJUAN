package com.xdl.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xdl.Mapper.UserMapper;
import com.xdl.bean.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@Api(value="v1",description="用户管理系统")
@RequestMapping("v1")
public class UserController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ApiOperation(value="登录接口",httpMethod="POST")
	public boolean getUserById(HttpServletResponse response,Integer id)
	{
		System.out.println("用户id:"+id);
		Integer n=userMapper.getUserById(id);
		log.info("查询到的结果是："+n);
		//System.out.println("用户n:"+n);
		if(n==1)
		{
			Cookie cookie=new Cookie("login","true");
			response.addCookie(cookie);
			log.info("登录的用户是："+id);
			return true;
		}
		return false;
		
	}
	
	@RequestMapping(value="/getUserInfo",method=RequestMethod.POST)
	@ApiOperation(value="获取用户信息列表接口",httpMethod="POST")
	public List<User> getUsers(HttpServletRequest request) {
	       boolean verify=verifyCookie(request);
	       System.out.println("verify:"+verify);
	        List<User> list=null;
	        System.out.println("list:"+list);
	        if(verify==true)
	        {
	        	list=userMapper.getUsers();
	        }
	        
	        if(list!=null)
	        {
	        	log.info("查询到的用户数量为："+list.size());
	        	return list;
	        }
			return null;	
		
	}
	
	public boolean verifyCookie(HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		if(cookies==null)
		{
			log.info("cookie为空");
			return false;
		}
		
		for(Cookie c:cookies)
		{
			if(c!=null) {
				
			
			if(c.getName().equals("login")&&c.getValue().equals("true"))
			{
				log.info("cookie验证通过");
				return true;
			}
			}
		}
		return false;		
	}
	

	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	@ApiOperation(value="添加用户接口",httpMethod="POST")
	public boolean addUser(@RequestBody User user,HttpServletRequest request) {
        boolean verify=verifyCookie(request);
        Integer result=0;
        if(verify==true)
        {
        	result=userMapper.addUser(user.getName(),user.getAge(),user.getSex());
        }
        
        if(result>0)
        {
        	log.info("添加用户的数量为："+result);
        	return true;
        }
		return false;		
	}
	
	
	@RequestMapping(value="/updateUserInfo",method=RequestMethod.POST)
	@ApiOperation(value="更新用户接口",httpMethod="POST")
	public Integer updateUser(@RequestBody User user,HttpServletRequest request) {
        boolean verify=verifyCookie(request);
        Integer result=0;
        if(verify==true)
        {
        	result=userMapper.updateUser(user.getSex(),user.getId());
        }
        
        if(result>0)
        {
        	
        	log.info("更新用户的数量为："+result);
        	return result;
        }
		return result;			
	}
	

}
