package al.jfc.service.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import al.jfc.model.User;
import al.jfc.repository.UserRepository;
import al.jfc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean isBirthdayToday(int userId) {
		User user = userRepository.findById((long)userId);
	    // Assuming 'birthday' is the Date field in your class
		 Date birthday = user.getBirthday();   
		 if (birthday != null) {
		        // Convert java.sql.Date to LocalDate
			  Instant b = new java.util.Date(birthday.getTime()).toInstant();
		      LocalDate birthdayLocalDate = b.atZone(ZoneId.systemDefault()).toLocalDate();

		      LocalDate currentLocalDate = LocalDate.now();

		      return birthdayLocalDate.getMonth() == currentLocalDate.getMonth() &&
		               birthdayLocalDate.getDayOfMonth() == currentLocalDate.getDayOfMonth();
		  } else {
			  return false; // Handle the case when birthday is not found in the database
		  }
	}

}
