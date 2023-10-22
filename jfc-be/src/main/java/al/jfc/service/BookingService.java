package al.jfc.service;

import java.util.List;

import al.jfc.model.BookingUser;
import al.jfc.rest.dto.BookingRequest;

public interface BookingService {

	void createOrUpdateBooking(BookingRequest bookingRequest);

	List<BookingUser> findUserBookings(int userId);

}
