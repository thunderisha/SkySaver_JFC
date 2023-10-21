package al.jfc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import al.jfc.model.PuzzleFile;
import al.jfc.model.PuzzleLevel;

public interface PuzzleFileRepository extends JpaRepository<PuzzleFile, Long>{
	
	@Query("SELECT p FROM PuzzleFile p WHERE p.puzzle.id = :idpuzzle ORDER BY p.row")
	List<PuzzleFile> findByPuzzle(long idpuzzle);
}
