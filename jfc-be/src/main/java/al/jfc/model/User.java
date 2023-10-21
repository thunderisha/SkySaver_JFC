package al.jfc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "id")
	private long id;
	
	@Column(name = "email")
	private String email ;
	
	@Column(name = "username")
	private String username ;


}
