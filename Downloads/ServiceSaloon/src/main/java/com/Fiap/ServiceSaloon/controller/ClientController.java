package com.Fiap.ServiceSaloon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fiap.ServiceSaloon.dto.ReservationDTO;
import com.Fiap.ServiceSaloon.dto.ReviewDTO;
import com.Fiap.ServiceSaloon.services.client.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/ads")
     public ResponseEntity<?> getAllAds(){
		return ResponseEntity.ok(clientService.getAllAds());
	}
	
	@GetMapping("/search/{name}")
    public ResponseEntity<?> searchAdByService(@PathVariable String name){
		return ResponseEntity.ok(clientService.searchAdByName(name));
	}
	
	@PostMapping("/book-service")
    public ResponseEntity<?> bookService(@RequestBody ReservationDTO reservationDTO ){
		boolean sucess = clientService.bookService(reservationDTO);
		
		if(sucess) {
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/ad/{adId}")
    public ResponseEntity<?> getAdDetailsbyAdId (@PathVariable long adId){
		return ResponseEntity.ok(clientService.getAdDetailsByAdId(adId));
	}
	
	@GetMapping("/my-bookings/{userId}")
    public ResponseEntity<?> getAllBookingsByUserId(@PathVariable long userId){
		return ResponseEntity.ok(clientService.getAllBookingsByUserId(userId));
	}
	
	@PostMapping("/review")
    public ResponseEntity<?> giveReview(@RequestBody ReviewDTO reviewDTO ){
		boolean sucess = clientService.giveReview(reviewDTO);
		
		if(sucess) {
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
