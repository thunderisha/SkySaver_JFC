package al.jfc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="gamefication_events")
@NamedQuery(name="GameficationEvent.findAll", query="SELECT g FROM GameficationEvent g")
public class GameficationEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	//bi-directional many-to-one association to Level
	@ManyToOne
	private GameficationRule rule;

	//bi-directional many-to-one association to User
	@OneToOne
	private User user;

	public GameficationEvent() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	

	public GameficationRule getRule() {
		return rule;
	}

	public void setRule(GameficationRule rule) {
		this.rule = rule;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}