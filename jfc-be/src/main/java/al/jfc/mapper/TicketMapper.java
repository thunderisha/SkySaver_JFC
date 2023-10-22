package al.jfc.mapper;

import al.jfc.model.TicketUser;
import al.jfc.rest.dto.Ticket;

public interface TicketMapper {
	
	public TicketUser toEntity(Ticket dto);

}
