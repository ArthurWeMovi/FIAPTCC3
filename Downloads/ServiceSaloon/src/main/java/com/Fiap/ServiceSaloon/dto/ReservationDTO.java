package com.Fiap.ServiceSaloon.dto;

import java.util.Date;

import com.Fiap.ServiceSaloon.enums.ReservationStatus;
import com.Fiap.ServiceSaloon.enums.ReviewStatus;

import lombok.Data;

@Data
public class ReservationDTO {
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public ReviewStatus getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(ReviewStatus reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getAdId() {
		return adId;
	}

	public void setAdId(long adId) {
		this.adId = adId;
	}

	private long id;
	
	private Date bookDate;
	
	private String serviceName;
	
	private ReservationStatus reservationStatus;
	
	private ReviewStatus reviewStatus;
	
	private long userId;
	
	private String userName;
	
	private long companyId;

	private long adId;
}
