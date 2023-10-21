package al.jfc.rest.dto;

import java.util.List;

public class Ticket {
    private String ticketNumber;
    private String ticketingAirline;
    private String ticketStatus;
    private String issuedDate;
    private Traveller traveller;
    private List<BookedSegment> bookedSegments;

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketingAirline() {
        return ticketingAirline;
    }

    public void setTicketingAirline(String ticketingAirline) {
        this.ticketingAirline = ticketingAirline;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    public List<BookedSegment> getBookedSegments() {
        return bookedSegments;
    }

    public void setBookedSegments(List<BookedSegment> bookedSegments) {
        this.bookedSegments = bookedSegments;
    }
}

