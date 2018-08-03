package com.xdl.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.Cookie;

import com.alibaba.fastjson.JSONObject;
import com.xdl.Application;
import com.xdl.Mapper.UserMapper;
import com.xdl.bean.AddUserCase;
import com.xdl.bean.LoginCase;
import com.xdl.bean.User;
import com.xdl.config.TestConfig;

import junit.framework.TestCase;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TestUserController extends AbstractTestNGSpringContextTests{
	@Autowired
    private MockMvc mvc;

	@Autowired
	UserMapper userMapper;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
    @Test
    public void test1() {
    	TestCase.assertEquals(1, 1);
    }


    @Test
    public void loginTrueTest() throws Exception {
    	LoginCase loginCase = userMapper.loginCase(1);
    	ResultActions n=mvc.perform(MockMvcRequestBuilders.post("/v1/login").param("id",String.valueOf((loginCase.getUserid()))));

    	logger.info("用户登录成功info");
    	logger.error("用户登录成功error");
    	logger.warn("用户登录成功warn");
        n.andExpect(MockMvcResultMatchers.content().string(equalTo(loginCase.getExpected())));
    	
    	Cookie[] cookie=n.andReturn().getResponse().getCookies();   	
    	
    	if(cookie!=null) {
    	for(Cookie c:cookie)
    	{
    		if(c!=null) {
    			
    		
    		if(c.getName().equals("login")&&c.getValue().equals("true"))
    		{
    			TestConfig.store=c;
    		}
    		}
    	}
    	}
    	
    }
    
    @Test
    public void loginFalseTest() throws Exception {
    	LoginCase loginCase = userMapper.loginCase(2);
    	ResultActions n=mvc.perform(MockMvcRequestBuilders.post("/v1/login").param("id",String.valueOf((loginCase.getUserid()))))
        		.andExpect(MockMvcResultMatchers.content().string(equalTo(loginCase.getExpected())));
    	logger.info("用户登录成失败info");
    	logger.error("用户登录失败error");
    	logger.warn("用户登录失败warn");
    }
    
    @Test(dependsOnMethods="loginTrueTest")
    public void addUserTest() throws Exception {
    	logger.info("1添加用户失败info");
    	logger.error("1添加用户失败error");
    	logger.warn("1添加用户失败warn");
    	AddUserCase addUserCase = userMapper.addUserCase(2);
    	User user=new User();
    	user.setName(addUserCase.getName());
    	user.setAge(addUserCase.getAge());
    	user.setSex(addUserCase.getSex());
    	String userJSON=JSONObject.toJSONString(user);
    	mvc.perform(MockMvcRequestBuilders.post("/v1/addUser").cookie(TestConfig.store).contentType(MediaType.APPLICATION_JSON).content(userJSON).accept(MediaType.APPLICATION_JSON))
        		.andExpect(MockMvcResultMatchers.content().string(equalTo("true")));
    	logger.info("添加用户失败info");
    	logger.error("添加用户失败error");
    	logger.warn("添加用户失败warn");
    }
   
}
