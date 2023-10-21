package al.jfc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the puzzle_level database table.
 * 
 */
@Entity
@Table(name="puzzle_level")
@NamedQuery(name="PuzzleLevel.findAll", query="SELECT p FROM PuzzleLevel p")
public class PuzzleLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idpuzzle_level")
	private int idpuzzleLevel;

	//bi-directional many-to-one association to Level
	@OneToOne
	private Level level;

	//bi-directional many-to-one association to Puzzle
	@OneToOne
	@JoinColumn(name="puzzle_id")
	private Puzzle puzzle;

	public PuzzleLevel() {
	}

	public int getIdpuzzleLevel() {
		return this.idpuzzleLevel;
	}

	public void setIdpuzzleLevel(int idpuzzleLevel) {
		this.idpuzzleLevel = idpuzzleLevel;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Puzzle getPuzzle() {
		return this.puzzle;
	}

	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}

}