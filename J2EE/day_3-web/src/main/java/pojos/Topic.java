package pojos;

public class Topic {
	// Data Members
	private int id;
	private String name;

	// Constructors
	public Topic() {
	}

	public Topic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// To String
	@Override
	public String toString() {
		return "Topic\nId : " + id + "\nName=" + name + "\n";
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
