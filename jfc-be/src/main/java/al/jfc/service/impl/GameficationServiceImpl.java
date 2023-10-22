package al.jfc.service.impl;

import java.util.List;
import java.util.jar.JarException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.jfc.dto.UserProfileDto;
import al.jfc.exceptions.JFCException;
import al.jfc.model.GameficationEvent;
import al.jfc.model.Level;
import al.jfc.model.PuzzleFile;
import al.jfc.model.PuzzleLevel;
import al.jfc.model.Reward;
import al.jfc.model.User;
import al.jfc.model.UserChallengeLevel;
import al.jfc.repository.GameficationEventRepository;
import al.jfc.repository.LevelRepository;
import al.jfc.repository.PuzzleFileRepository;
import al.jfc.repository.PuzzleLevelRepository;
import al.jfc.repository.RewardRepository;
import al.jfc.repository.UserChallengeLevelRepository;
import al.jfc.repository.UserRepository;
import al.jfc.service.GamificationService;
import al.jfc.utils.Constants;

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
	@Autowired 
	RewardRepository rewardRepository;
	
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
			//Ketu eshte formula ku kemi vendosur qe sa puzzle do shfaqim (ne momentin qe piket shtohen me 5)
			int rowToShow = (points - (20 * (((int)level.getId())-1)))/5;
			PuzzleLevel puzzleLevel = puzzleLevelRepository.findByLevel(level.getId());
			if(puzzleLevel != null) {
				List<PuzzleFile> listFilePuzzle = puzzleFileRepository.findByPuzzle(puzzleLevel.getPuzzle().getIdpuzzle());
				List<PuzzleFile> listPuzzleToShow = listFilePuzzle.stream().filter(el -> el.getRow()<= rowToShow)
			    .collect(Collectors.toList());
				userProfile.setPuzzleFiles(listPuzzleToShow);
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
		if(level != null){

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

	@Override
	public List<Reward> getLevelRewards(){
		List<Reward> listRewards = rewardRepository.findAll();
		if(!listRewards.isEmpty()) {
			return listRewards;
		}else {
			throw new JFCException(Constants.NO_DATA);
		}
		
	}
}
