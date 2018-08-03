package com.xdl.bean;

import java.io.Serializable;

public class GetUserListCase implements Serializable {
	private int id;
	private String name;
	private int age;
	private String expected;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getExpected() {
		return expected;
	}
	public void setExpected(String expected) {
		this.expected = expected;
	}
	@Override
	public String toString() {
		return "GetUserListCase [id=" + id + ", name=" + name + ", age=" + age + ", expected=" + expected + "]";
	}
	
}
