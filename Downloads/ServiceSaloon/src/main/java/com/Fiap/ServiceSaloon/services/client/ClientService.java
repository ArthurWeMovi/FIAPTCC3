package com.Fiap.ServiceSaloon.services.client;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Fiap.ServiceSaloon.dto.AdDTO;
import com.Fiap.ServiceSaloon.dto.AdDetailsForClientDTO;
import com.Fiap.ServiceSaloon.dto.ReservationDTO;
import com.Fiap.ServiceSaloon.dto.ReviewDTO;


public interface ClientService {
	
	List<AdDTO> getAllAds();
	
	List<AdDTO> searchAdByName(String name);
	
	boolean bookService(ReservationDTO reservationDTO);
	
	AdDetailsForClientDTO getAdDetailsByAdId(Long adId);
	
	List<ReservationDTO> getAllBookingsByUserId(Long userId);
	
	boolean giveReview(ReviewDTO reviewDTO);
}
