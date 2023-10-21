package al.jfc.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="rewards")
@NamedQuery(name="Reward.findAll", query="SELECT r FROM Reward r")
public class Reward implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idreward;

	private String description;

	@OneToOne
	private Level level;


	public Reward() {
	}

	public int getIdreward() {
		return this.idreward;
	}

	public void setIdreward(int idreward) {
		this.idreward = idreward;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
