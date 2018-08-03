package com.xdl.test;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.xdl.Application;
import com.xdl.Mapper.UserMapper;
import com.xdl.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {Application.class})
public class TestDemoUserCon {

	@Autowired
	UserMapper userMapper;
	@Autowired	
	UserController userController;
	
	@Test
	public void test() {
		Integer n=userMapper.getUserById(2);
		System.out.println(n);
		
	}
	
	
	/*   private MockMvc mvc;

	   @Before
	    public void setUp() throws Exception {
	        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	    }

	    @Test
	    public void testUserController() throws Exception {// 测试UserController

	        // 1、get查一下user列表，应该为空
	        mvc.perform(MockMvcRequestBuilders.get("/users/"))
	                .andExpect(status().isOk())
	                .andExpect(content().string(equalTo("[]")));


	        // 2、post提交一个user
	        mvc.perform(MockMvcRequestBuilders.post("/v1/login").param("id", "2"))
	        		.andExpect(content().string(equalTo("true")));
	*/
/*	@Test
	public void test1(HttpServletResponse response) {
		User user=new User();
		user.setId(2);
		user.setName("zhang");
		user.setAge(20);
		user.setSex(null);
		boolean b=userController.getUserById(response, user);
		System.out.println(b);
	}*/
	   // }
}
