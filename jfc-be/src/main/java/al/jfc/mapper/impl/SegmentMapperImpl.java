package al.jfc.mapper.impl;

import org.springframework.stereotype.Component;

import al.jfc.mapper.SegmentMapper;
import al.jfc.model.Segment;
import al.jfc.rest.dto.BookedSegment;

@Component
public class SegmentMapperImpl implements SegmentMapper{

	@Override
	public Segment toEntity(BookedSegment dto) {
		Segment segment = new Segment();
		if(dto.getArrivalDate() != null) {
			segment.setArrivalDate(dto.getArrivalDate());
		}
		if(dto.getDepartureDate() != null) {
			segment.setDepartureDate(dto.getDepartureDate());
		}
		if(dto.getBookingClass() != null) {
			segment.setBookingClass(dto.getBookingClass());
		}
		if(dto.getDestination() != null) {
			segment.setDestination(dto.getDestination());
		}
		if(dto.getOrigin() != null) {
			segment.setOrigin(dto.getOrigin());
		}
		return segment;
	}

}
