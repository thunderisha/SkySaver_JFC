package al.jfc.model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the levels database table.
 * 
 */
@Entity
@Table(name="levels")
@NamedQuery(name="Level.findAll", query="SELECT l FROM Level l")
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String description;

	@Column(name="end_point")
	private int endPoint;

	@Column(name="start_point")
	private int startPoint;


	public Level() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEndPoint() {
		return this.endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}

	public int getStartPoint() {
		return this.startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}



}