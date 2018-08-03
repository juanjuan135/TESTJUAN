package com.xdl.cases;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.xdl.Application;
import com.xdl.Mapper.UserMapper;
import com.xdl.bean.LoginCase;
import com.xdl.config.TestConfig;
import com.xdl.controller.UserController;
import com.xdl.util.GetPropertiesUtil;

@SpringBootTest(classes = Application.class)
public class LoginTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
	UserMapper userMapper;

	
    private MockMvc mvc;

  /* @BeforeMethod
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
    	 mvc.perform(MockMvcRequestBuilders.post("/v1/login").param("id", "2"))
 		.andExpect(content().string(equalTo("true")));
    }*/
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test(groups = "loginTrue", description = "用户成功登陆接口")
	public void loginTrue() throws IOException, InterruptedException, JSONException {		
		LoginCase loginCase = userMapper.loginCase(1);
		System.out.println(loginCase);
		// 下边的代码为写完接口的测试代码
		String result = getResult(loginCase);
		Thread.sleep(5000);
		// 处理结果，就是判断返回结果是否符合预期
		Assert.assertEquals(loginCase.getExpected().toString(), result);
	}

	@Test(description = "用户登陆失败接口")
	public void loginFalse() throws IOException, InterruptedException, JSONException {
		System.out.println("登录失败");
		LoginCase loginCase = userMapper.loginCase(2);
		// 下边的代码为写完接口的测试代码
		String result = getResult(loginCase);
		Thread.sleep(5000);
		// 处理结果，就是判断返回结果是否符合预期
		Assert.assertEquals(loginCase.getExpected(), result);

	}

	private String getResult(LoginCase loginCase) throws IOException, JSONException {
		String url=GetPropertiesUtil.getUrl("test.url") + GetPropertiesUtil.getUrl("login.uri");
		HttpPost post = new HttpPost(url);
		JSONObject param = new JSONObject();
		param.put("userid", loginCase.getUserid());
		param.put("expected", loginCase.getExpected());
		StringEntity entity = new StringEntity(param.toString(), "utf-8");
		post.setEntity(entity);
		post.setHeader("content-type", "application/json");
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(post);
		String result = EntityUtils.toString(response.getEntity());
		TestConfig.store = client.getCookieStore();
		return result;
	}*/
}
