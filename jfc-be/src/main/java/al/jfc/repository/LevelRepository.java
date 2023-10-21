package al.jfc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import al.jfc.model.Level;


public interface LevelRepository extends JpaRepository<Level, Long>{
	
	@Query("SELECT l FROM Level l WHERE l.startPoint < :point AND l.endPoint > :point")
    Level getLevel(int point);
}
