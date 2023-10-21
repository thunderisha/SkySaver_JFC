package al.jfc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import al.jfc.model.GameficationEvent;

public interface GameficationEventRepository extends JpaRepository<GameficationEvent, Long> {

	@Query("SELECT g FROM GameficationEvent g WHERE g.user.id = :userId")
	List<GameficationEvent> findByUser(long userId);

}
