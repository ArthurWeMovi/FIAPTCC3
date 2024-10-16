package com.Fiap.ServiceSaloon.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fiap.ServiceSaloon.dto.AdDTO;
import com.Fiap.ServiceSaloon.dto.ReservationDTO;
import com.Fiap.ServiceSaloon.entity.Reservation;
import com.Fiap.ServiceSaloon.services.company.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	
	@PostMapping("/ad/{userid}")
	public ResponseEntity<?> postAd(@PathVariable Long userId, @ModelAttribute AdDTO adDTO) throws IOException{
		
		boolean sucess = companyService.postAd(userId, adDTO);
		
		if(sucess) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
			
	}
	
	
	@GetMapping("/ads/{userid}")
	public ResponseEntity<?> getAllAdsByUserId(@PathVariable Long userId){
		
		return ResponseEntity.ok(companyService.getAllAds(userId));
	}
	

	@GetMapping("/ad/{adId}")
	public ResponseEntity<?> getAdById(@PathVariable Long adId){
		AdDTO adDTO = companyService.getAdById(adId);
		if(adDTO != null) {
			return ResponseEntity.ok(adDTO);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@PutMapping("/ad/{adId}")
	public ResponseEntity<?> updateAd(@PathVariable Long adId, @ModelAttribute AdDTO adDTO) throws IOException{
		boolean sucess = companyService.updatedAd(adId, adDTO);
		
		if(sucess) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@DeleteMapping("/ad/{adId}")
	public ResponseEntity<?> deleteAd(@PathVariable Long adId){
      boolean sucess = companyService.deleteAd(adId);
		
		if(sucess) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@GetMapping("/booking/{companyId}")
		
	public ResponseEntity<List<ReservationDTO>> getAllAdBokings(@PathVariable Long companyId){
		return ResponseEntity.ok(companyService.getAllAdBokings(companyId));
	}
	
	@GetMapping("/booking/{bookingId}/{status}")
	public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookingId, @PathVariable String status){
		boolean sucess = companyService.changeBookingStatus(bookingId, status);
		if(sucess) return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}
			
}
