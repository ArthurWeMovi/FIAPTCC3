package com.Fiap.ServiceSaloon.services.company;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.Fiap.ServiceSaloon.dto.AdDTO;
import com.Fiap.ServiceSaloon.dto.ReservationDTO;
import com.Fiap.ServiceSaloon.entity.Ad;

public interface CompanyService {
	
	 boolean postAd(Long userId, AdDTO adDTO) throws IOException;
	 
	 List<AdDTO> getAllAds(Long userId);
	 
	 AdDTO getAdById(Long adId);
	 
	 boolean updatedAd(Long adId, AdDTO adDTO) throws IOException;
	 
	 boolean deleteAd(Long adId);
	 
	 List<ReservationDTO> getAllAdBokings(long companyId);
	 
	 boolean changeBookingStatus(Long bookingId, String status);
	 

}
