package al.jfc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_challenge_level database table.
 * 
 */
@Entity
@Table(name="user_challenge_level")
@NamedQuery(name="UserChallengeLevel.findAll", query="SELECT u FROM UserChallengeLevel u")
public class UserChallengeLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	//bi-directional many-to-one association to Level
	@OneToOne
	@JoinColumn(name="challenge_level_id")
	private Level level;

	//bi-directional many-to-one association to User
	@OneToOne
	private User user;
	
	private byte active;
	
	private String code;

	public UserChallengeLevel() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}