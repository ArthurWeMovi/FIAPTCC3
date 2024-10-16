package com.Fiap.ServiceSaloon.dto;

import java.util.List;

import lombok.Data;

@Data
public class AdDetailsForClientDTO {
	
	private AdDTO adDTO;

	public AdDTO getAdDTO() {
		return adDTO;
	}

	public void setAdDTO(AdDTO adDTO) {
		this.adDTO = adDTO;
	}
	
	private List<ReviewDTO> reviewDTOList;

	public List<ReviewDTO> getReviewDTOList() {
		return reviewDTOList;
	}

	public void setReviewDTOList(List<ReviewDTO> reviewDTOList) {
		this.reviewDTOList = reviewDTOList;
	}

}