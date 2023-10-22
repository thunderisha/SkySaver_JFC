package al.jfc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
@NamedQuery(name="TicketUser.findAll", query="SELECT t FROM TicketUser t")
public class TicketUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "idticket")
	private long idticket;
	
	@Column(name = "ticketNumber")
	private String ticketNumber;
	
	@Column(name = "ticketStatus")
	private String ticketStatus;
	
	@OneToMany(mappedBy = "idsegment", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Segment> segments;

	public TicketUser() {
	}

	public long getIdticket() {
		return idticket;
	}

	public void setIdticket(long idticket) {
		this.idticket = idticket;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	
}
