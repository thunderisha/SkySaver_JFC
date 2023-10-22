package al.jfc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@NamedQuery(name="Segment.findAll", query="SELECT s FROM Segment s")
public class Segment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long idsegment;

	private String arrivalDate;

	private String bookingClass;

	private String departureDate;

	private String destination;

	private String origin;

	public Segment() {
	}

	public long getIdsegment() {
		return this.idsegment;
	}

	public void setIdsegment(long idsegment) {
		this.idsegment = idsegment;
	}

	public String getBookingClass() {
		return this.bookingClass;
	}

	public void setBookingClass(String bookingClass) {
		this.bookingClass = bookingClass;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	

}
