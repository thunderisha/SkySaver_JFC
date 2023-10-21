package al.jfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import al.jfc.service.UserService;
import al.jfc.utils.ResponseHandler;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/birthday")
	public ResponseEntity<Object> dettaglioAlloggio(int userId) {
		return ResponseHandler.generateResponse("OK", HttpStatus.OK, userService.isBirthdayToday(userId));
	}
}
