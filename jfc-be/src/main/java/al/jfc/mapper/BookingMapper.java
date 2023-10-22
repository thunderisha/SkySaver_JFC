package al.jfc.mapper;

import al.jfc.model.BookingUser;
import al.jfc.rest.dto.BookingRequest;

public interface BookingMapper {
	
	public BookingUser toEntity(BookingRequest dto);

}
