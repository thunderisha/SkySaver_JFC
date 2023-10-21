package al.jfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import al.jfc.model.Puzzle;

public interface PuzzleRepository  extends JpaRepository<Puzzle, Long>{

}
