package al.jfc.controller;

import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import al.jfc.rest.dto.Booking;
import al.jfc.rest.dto.BookingRequest;
import al.jfc.service.BookingService;
import al.jfc.utils.Constants;
import al.jfc.utils.ResponseHandler;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/booking")
public class BookingController{
	@Autowired
	private BookingService bookingService;

	@PutMapping
	public ResponseEntity<Object> putBooking(@RequestBody BookingRequest bookingData) {
		bookingService.createOrUpdateBooking(bookingData);
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, Constants.BOOKING_SUCCESS);
    }
	
	@GetMapping("/of/user")
	public ResponseEntity<Object> getGamificationUserProfile(int userId) {
		return ResponseHandler.generateResponse("OK", HttpStatus.OK, bookingService.findUserBookings(userId));
	}
  
    
}
