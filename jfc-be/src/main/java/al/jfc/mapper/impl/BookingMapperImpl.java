package al.jfc.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.jfc.mapper.BookingMapper;
import al.jfc.mapper.SegmentMapper;
import al.jfc.mapper.TicketMapper;
import al.jfc.model.BookingUser;
import al.jfc.model.Segment;
import al.jfc.model.TicketUser;
import al.jfc.repository.UserRepository;
import al.jfc.rest.dto.BookedSegment;
import al.jfc.rest.dto.BookingRequest;
import al.jfc.rest.dto.Ticket;

@Component
public class BookingMapperImpl implements BookingMapper{
	@Autowired
	TicketMapper ticketMapper;
	@Autowired
	UserRepository userRepository;
	@Autowired
	SegmentMapper segmentMapper;
	

	@Override
	public BookingUser toEntity(BookingRequest dto) {
		BookingUser bookingUser = new BookingUser();
		if(dto.getTickets()!= null) {
			List<TicketUser> listTicketDto = new ArrayList<>();
			for (Ticket ticket : dto.getTickets()) {
				List<Segment> listSegment = new ArrayList<>();
				for (BookedSegment segment : ticket.getBookedSegments()) {
					listSegment.add(segmentMapper.toEntity(segment));
				}
				TicketUser ticketU = ticketMapper.toEntity(ticket);
				ticketU.setSegments(listSegment);
				listTicketDto.add(ticketU);
			}
			bookingUser.setTickets(listTicketDto);
		}
		if(dto.getUser().getEmail()!= null) {
			bookingUser.setUserId((int)userRepository.findByEmail(dto.getUser().getEmail()).getId());
		}
		return bookingUser;
	}


	

}
