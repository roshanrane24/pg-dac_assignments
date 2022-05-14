package pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic extends BaseEntity {
	private String name;
	
	// Constructors
	public Topic() {
	}

	public Topic(String name) {
		this.name = name;
	}

	// To String
	@Override
	public String toString() {
		return "Topic\nId : " + super.getId() + "\nName=" + name + "\n";
	}

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
