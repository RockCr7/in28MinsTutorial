package com.lcwd.user.service.versioning;

public class PersonV1 {
	private String name;
	
	public PersonV1(String fullName) {
		this.name=fullName;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
