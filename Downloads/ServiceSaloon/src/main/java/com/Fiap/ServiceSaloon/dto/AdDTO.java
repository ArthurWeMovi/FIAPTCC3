package com.Fiap.ServiceSaloon.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class AdDTO {
	
private Long id;
	
	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getServiceName() {
	return serviceName;
}

public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public byte[] getReturnedtImg() {
	return Returnedimg;
}

public void setReturnedImg(byte[] img) {
}

public long getUserId() {
	return userId;
}

public void setUserId(long userId) {
	this.userId = userId;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

	private String serviceName;
	
	private String description;
	
	private Double price;
	
	private byte[] Returnedimg;
	
	private long userId;
	
	private String companyName;
	
	private MultipartFile img;

	public byte[] getReturnedimg() {
		return Returnedimg;
	}

	public void setReturnedimg(byte[] returnedimg) {
		Returnedimg = returnedimg;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}
	
	

}
