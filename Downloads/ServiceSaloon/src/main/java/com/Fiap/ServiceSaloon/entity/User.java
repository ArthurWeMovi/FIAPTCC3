package com.Fiap.ServiceSaloon.entity;

import com.Fiap.ServiceSaloon.dto.UserDto;
import com.Fiap.ServiceSaloon.enums.UserRole;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
	
   public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public UserRole getRole() {
		return role;
	}



	public void setRole(UserRole role) {
		this.role = role;
	}



@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
   private String email;
   
   private String password;
   
   private String name;
   
   private String lastname;
   
   private String phone;
   
   private UserRole role;
   
   
   
   public UserDto getDto() {
	   UserDto userDto = new UserDto();
	   
	   userDto.setId(id);
	   userDto.setName(name);
	   userDto.setEmail(email);
	   userDto.setRole(role);
	   
	   return userDto;
	   
	   
	   
   }



public String setLastName(String name2) {
	
	
	return name2;
	
}

}
