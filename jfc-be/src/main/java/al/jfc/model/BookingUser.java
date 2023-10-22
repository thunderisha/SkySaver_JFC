package al.jfc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="booking_user")
@NamedQuery(name="BookingUser.findAll", query="SELECT b FROM BookingUser b")
public class BookingUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "idbooking")
	private long idbooking;


	@OneToMany(mappedBy = "idticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketUser> tickets;

	@Column(name = "user_id")
	private int userId;

	public BookingUser() {
	}

	public long getIdbooking() {
		return this.idbooking;
	}

	public void setIdbooking(long idbooking) {
		this.idbooking = idbooking;
	}




	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<TicketUser> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketUser> tickets) {
		this.tickets = tickets;
	}
	
	

}