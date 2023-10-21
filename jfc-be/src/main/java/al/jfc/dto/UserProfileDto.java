package al.jfc.dto;

import java.util.List;

import al.jfc.model.Level;
import al.jfc.model.PuzzleFile;
import al.jfc.model.User;

public class UserProfileDto {
	
	User user;
	Level level;
	int points;
	List<PuzzleFile> puzzleFiles;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public List<PuzzleFile> getPuzzleFiles() {
		return puzzleFiles;
	}
	public void setPuzzleFiles(List<PuzzleFile> puzzleFiles) {
		this.puzzleFiles = puzzleFiles;
	}
	
	
	

}
