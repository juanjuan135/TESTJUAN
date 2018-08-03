package com.xdl.cases;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xdl.Mapper.UserMapper;
import com.xdl.bean.AddUserCase;
import com.xdl.config.TestConfig;
import com.xdl.util.GetPropertiesUtil;

@Service
public class AddUserTest {
	@Autowired
	UserMapper userMapper;

	@Test(dependsOnGroups = "loginTrue", description = "添加用户接口接口")
	public void addUser() throws IOException, JSONException {
		AddUserCase addUserCase = userMapper.addUserCase(1);
		System.out.println(addUserCase);
		// 发送请求，获取结果
		String result = getResult(addUserCase);

		// 验证结果
		Assert.assertEquals(addUserCase.getExpected(), result);
	}

	private String getResult(AddUserCase addUserCase) throws IOException, JSONException {
		HttpPost httpPost = new HttpPost(
				GetPropertiesUtil.getUrl("test.url") + GetPropertiesUtil.getUrl("addUser.uri"));
		JSONObject param = new JSONObject();
		param.put("name", addUserCase.getName());
		param.put("age", addUserCase.getAge());
		param.put("sex", addUserCase.getSex());
		StringEntity entry = new StringEntity(param.toString(), "utf-8");
		httpPost.setEntity(entry);
		httpPost.addHeader("content-type", "application/json");
		DefaultHttpClient client = new DefaultHttpClient();
		//client.setCookieStore(TestConfig.store);
		HttpResponse response = client.execute(httpPost);
		String result = EntityUtils.toString(response.getEntity(), "utf-8");
		return result;
	}

}
