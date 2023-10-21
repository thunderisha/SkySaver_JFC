package al.jfc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.jfc.dto.UserProfileDto;
import al.jfc.model.GameficationEvent;
import al.jfc.model.Level;
import al.jfc.model.PuzzleFile;
import al.jfc.model.PuzzleLevel;
import al.jfc.model.User;
import al.jfc.model.UserChallengeLevel;
import al.jfc.repository.GameficationEventRepository;
import al.jfc.repository.LevelRepository;
import al.jfc.repository.PuzzleFileRepository;
import al.jfc.repository.PuzzleLevelRepository;
import al.jfc.repository.UserChallengeLevelRepository;
import al.jfc.repository.UserRepository;
import al.jfc.service.GamificationService;

@Service
public class GameficationServiceImpl implements GamificationService{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	GameficationEventRepository gameficationEventRepository;
	@Autowired
	LevelRepository levelRepository;
	@Autowired
	PuzzleLevelRepository puzzleLevelRepository;
	@Autowired
	PuzzleFileRepository puzzleFileRepository;
	@Autowired
	UserChallengeLevelRepository userChallengeLevelRepository;
	
	@Override
	public UserProfileDto getUserProfileGamification(Integer userId) {
	
		UserProfileDto userProfile =  new UserProfileDto();
		User user = userRepository.findById((long)userId);
		userProfile.setUser(user);
		int points = 0;
		List<GameficationEvent> events =  gameficationEventRepository.findByUser(userId);
		if(events != null && !events.isEmpty()) {
			for (GameficationEvent gameficationEvent : events) {
				points += gameficationEvent.getRule().getRulePoint();
			}
		}
		userProfile.setPoints(points);
		Level level = null;
		if(points != 0) {
			level = levelRepository.getLevel(points);
			userProfile.setLevel(level);
		}
		if(level != null) {
			PuzzleLevel puzzleLevel = puzzleLevelRepository.findByLevel(level.getId());
			if(puzzleLevel != null) {
				List<PuzzleFile> listFilePuzzle = puzzleFileRepository.findByPuzzle(puzzleLevel.getPuzzle().getIdpuzzle());
				userProfile.setPuzzleFiles(listFilePuzzle);
			}
		}
		return userProfile;
	}
	
	//Update user level in case of gamification event 
	@Override
	public void updateUserLevel(int userId) {
		User user = userRepository.findById((long)userId);
		int points = 0;
		List<GameficationEvent> events =  gameficationEventRepository.findByUser(userId);
		if(events != null && !events.isEmpty()) {
			for (GameficationEvent gameficationEvent : events) {
				points += gameficationEvent.getRule().getRulePoint();
			}
		}
		Level level = null;
		if(points != 0) {
			level = levelRepository.getLevel(points);
		}
		
		UserChallengeLevel userChallengeLevelExisting = userChallengeLevelRepository.findByUser((long)userId);

		UserChallengeLevel userChallengeLevel = new UserChallengeLevel();
		if(userChallengeLevelExisting != null) {
			userChallengeLevel = userChallengeLevelExisting;
		}
		userChallengeLevel.setUser(user);
		userChallengeLevel.setLevel(level);
		userChallengeLevelRepository.save(userChallengeLevel);
	}

}
