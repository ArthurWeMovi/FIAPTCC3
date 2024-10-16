package com.Fiap.ServiceSaloon.services.client;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fiap.ServiceSaloon.dto.AdDTO;
import com.Fiap.ServiceSaloon.dto.AdDetailsForClientDTO;
import com.Fiap.ServiceSaloon.dto.ReservationDTO;
import com.Fiap.ServiceSaloon.dto.ReviewDTO;
import com.Fiap.ServiceSaloon.entity.Ad;
import com.Fiap.ServiceSaloon.entity.Reservation;
import com.Fiap.ServiceSaloon.entity.Review;
import com.Fiap.ServiceSaloon.entity.User;
import com.Fiap.ServiceSaloon.enums.ReservationStatus;
import com.Fiap.ServiceSaloon.enums.ReviewStatus;
import com.Fiap.ServiceSaloon.repository.AdRepository;
import com.Fiap.ServiceSaloon.repository.ReservationRepository;
import com.Fiap.ServiceSaloon.repository.ReviewRepository;
import com.Fiap.ServiceSaloon.repository.UserRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private AdRepository adRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	public List<AdDTO> getAllAds(){
		return adRepository.findAll().stream().map(Ad::getAdDto).collect(Collectors.toList());
	}
	
	public List<AdDTO> searchAdByName(String name){
		return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDto).collect(Collectors.toList());
	
}
	
	public boolean bookService(ReservationDTO reservationDTO) {
		
		Optional<Ad> optionalAd = adRepository.findById(reservationDTO.getAdId());
		Optional<User> optionalUser = userRepository.findById(reservationDTO.getUserId());
		
		if(optionalAd.isPresent() && optionalUser.isPresent()) {
			
			Reservation reservation = new Reservation();
			
			reservation.setBookDate(reservationDTO.getBookDate());
			reservation.setReservationStatus(ReservationStatus.PENDING);
			reservation.setUser(optionalUser.get());
			
			reservation.setAd(optionalAd.get());
			reservation.setCompany(optionalAd.get().getUser());
			reservation.setReviewStatus(ReviewStatus.FALSE);
			
			reservationRepository.save(reservation);
			
			return true;
		}
		
		return false;
		
	}
	
	public AdDetailsForClientDTO getAdDetailsByAdId(Long adId) {
		
		Optional<Ad> optionalAd = adRepository.findById(adId);
		
		AdDetailsForClientDTO adDetailsForClientDTO = new AdDetailsForClientDTO();
		
		if(optionalAd.isPresent()) {
			adDetailsForClientDTO.setAdDTO(optionalAd.get().getAdDto());
			
			List<Review> reviewList = reviewRepository.findAllByAdId(adId);
			adDetailsForClientDTO.setReviewDTOList(reviewList.stream().map(Review::getDto).collect(Collectors.toList()));
		
		}
		
		return adDetailsForClientDTO;
	
	}
	
	public List<ReservationDTO> getAllBookingsByUserId(Long userId){
		return reservationRepository.findAllByUserId(userId).stream().map(Reservation::getReservationDto).collect(Collectors.toList());
	}
	
	public boolean giveReview(ReviewDTO reviewDTO) {
		
		Optional<User> optionalUser= userRepository.findById(reviewDTO.getUserId());
		Optional<Reservation> optionalBooking = reservationRepository.findById(reviewDTO.getBookId());
		
		if(optionalUser.isPresent() && optionalBooking.isPresent()) {
			Review review = new Review();
			
			review.setReviewDate(new Date());
			review.setReview(reviewDTO.getReview());
			
			review.setRating(reviewDTO.getRating());
			
			review.setUser(optionalUser.get());
			
			review.setAd(optionalBooking.get().getAd());
			
			reviewRepository.save(review);
			
			Reservation booking = optionalBooking.get();
			booking.setReviewStatus(ReviewStatus.TRUE);
			
			return true;
		}
		
		return false;
		
		
	}
}
