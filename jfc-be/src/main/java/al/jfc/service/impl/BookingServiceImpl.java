package al.jfc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.jfc.exceptions.JFCException;
import al.jfc.model.GameficationEvent;
import al.jfc.model.GameficationRule;
import al.jfc.model.User;
import al.jfc.repository.GameficationEventRepository;
import al.jfc.repository.GameficationRuleRepository;
import al.jfc.repository.UserRepository;
import al.jfc.rest.dto.BookingRequest;
import al.jfc.service.BookingService;
import al.jfc.service.GamificationService;
import al.jfc.utils.Constants;

@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	GameficationRuleRepository gameficationRuleRepository;
	@Autowired
	GameficationEventRepository gameficationEventRepository;
	@Autowired
	GamificationService gamificationService;

	public void createOrUpdateBooking(BookingRequest bookingRequest) {
		User user =  userRepository.findByEmail(bookingRequest.getUser().getEmail());
		if(user != null) {
			GameficationEvent gameficationEvent =  new GameficationEvent();
			gameficationEvent.setUser(user);
			gameficationEvent.setRule(gameficationRuleRepository.findByRuleName(Constants.BOOKING_RULE_NAME));
			gameficationEventRepository.save(gameficationEvent);
			gamificationService.updateUserLevel((int)user.getId());
		}else {
			throw new JFCException(Constants.USER_DOSENT_EXIST);
		}
		
	}

}
