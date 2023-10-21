package al.jfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import al.jfc.dto.UserProfileDto;
import al.jfc.service.GamificationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gamification")
public class GamificationController {
	@Autowired
	GamificationService gamificationService;

	
	 @GetMapping("/user/profile")
		public UserProfileDto dettaglioAlloggio(int userId) {
			return gamificationService.getUserProfileGamification(userId);
	}
}
