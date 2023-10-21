package al.jfc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the puzzle database table.
 * 
 */
@Entity
@NamedQuery(name="Puzzle.findAll", query="SELECT p FROM Puzzle p")
public class Puzzle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idpuzzle;

	private String description;

	

	public Puzzle() {
	}

	public long getIdpuzzle() {
		return this.idpuzzle;
	}

	public void setIdpuzzle(long idpuzzle) {
		this.idpuzzle = idpuzzle;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
