package al.jfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import al.jfc.dto.UserProfileDto;
import al.jfc.service.GamificationService;
import al.jfc.utils.Constants;
import al.jfc.utils.ResponseHandler;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gamification")
public class GamificationController {
	@Autowired
	GamificationService gamificationService;

	
	@GetMapping("/user")
	public ResponseEntity<Object> dettaglioAlloggio(int userId) {
		return ResponseHandler.generateResponse("OK", HttpStatus.OK, gamificationService.getUserProfileGamification(userId));
	}
	 

}
