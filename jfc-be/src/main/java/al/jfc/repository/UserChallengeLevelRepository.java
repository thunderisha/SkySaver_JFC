package al.jfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import al.jfc.model.UserChallengeLevel;

public interface UserChallengeLevelRepository extends JpaRepository<UserChallengeLevel, Long>{

	@Query("SELECT u FROM UserChallengeLevel u WHERE u.user.id = :userId")
	UserChallengeLevel findByUser(long userId);

}
