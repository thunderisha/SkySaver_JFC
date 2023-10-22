package al.jfc.mapper.impl;

import org.springframework.stereotype.Component;

import al.jfc.mapper.TicketMapper;
import al.jfc.model.TicketUser;
import al.jfc.rest.dto.Ticket;

@Component
public class TicketMapperImpl implements TicketMapper{

	@Override
	public TicketUser toEntity(Ticket dto) {
		TicketUser ticketUser = new TicketUser();
		if(dto.getTicketNumber() != null) {
			ticketUser.setTicketNumber(dto.getTicketNumber());
		}
		if(dto.getTicketStatus() != null) {
			ticketUser.setTicketStatus(dto.getTicketStatus());
		}
		return ticketUser;
	}

}
