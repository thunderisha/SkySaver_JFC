package al.jfc.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="gamefication_rules")
@NamedQuery(name="GameficationRule.findAll", query="SELECT g FROM GameficationRule g")
public class GameficationRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="rule_description")
	private String ruleDescription;

	@Column(name="rule_name")
	private String ruleName;

	@Column(name="rule_point")
	private int rulePoint;

	public GameficationRule() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRuleDescription() {
		return this.ruleDescription;
	}

	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}

	public String getRuleName() {
		return this.ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public int getRulePoint() {
		return this.rulePoint;
	}

	public void setRulePoint(int rulePoint) {
		this.rulePoint = rulePoint;
	}

}
