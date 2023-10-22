package al.jfc.mapper;

import al.jfc.model.BookingUser;
import al.jfc.model.Segment;
import al.jfc.rest.dto.BookedSegment;

public interface SegmentMapper {

	public Segment toEntity(BookedSegment dto);
}
