package al.jfc.service;

import al.jfc.rest.dto.BookingRequest;

public interface BookingService {

	void createOrUpdateBooking(BookingRequest bookingRequest);

}
