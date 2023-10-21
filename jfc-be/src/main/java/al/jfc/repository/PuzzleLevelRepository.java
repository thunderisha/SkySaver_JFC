package al.jfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import al.jfc.model.Level;
import al.jfc.model.PuzzleLevel;

public interface PuzzleLevelRepository extends JpaRepository<PuzzleLevel, Long>{

	@Query("SELECT p FROM PuzzleLevel p WHERE p.level.id = :levelId")
	PuzzleLevel findByLevel(long levelId);

}
