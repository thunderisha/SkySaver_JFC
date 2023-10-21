package al.jfc.service;

import java.util.List;

import al.jfc.dto.UserProfileDto;
import al.jfc.model.Reward;

public interface GamificationService {
	
	
	public UserProfileDto getUserProfileGamification(Integer userId);

	void updateUserLevel(int userId);

	List<Reward> getLevelRewards();

}
