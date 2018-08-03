package com.xdl.bean;

import java.io.Serializable;

public class LoginCase implements Serializable {
	private int id;
	private int userid;
	private String expected;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	@Override
	public String toString() {
		return "LoginCase [id=" + id + ", userid=" + userid + ", expected=" + expected + "]";
	}

}
