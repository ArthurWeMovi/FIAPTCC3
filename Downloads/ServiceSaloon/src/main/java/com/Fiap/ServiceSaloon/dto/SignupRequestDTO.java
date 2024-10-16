package com.Fiap.ServiceSaloon.dto;

import com.Fiap.ServiceSaloon.enums.UserRole;

import lombok.Data;


@Data
public class SignupRequestDTO {
	
	private long id;
	   
	   private String email;
	   
	   private String password;
	   
	   private String name;
	   
	   private String lastname;
	   
	   private String phone;

	public String  getName() {

		return this.name;
	}

	public String  getEmail() {

		return this.email;
	}

	public String  getPhone() {
	
		return this.phone;
	}

	public String  getPassword() {

		return this.password;
	}
	   


}
