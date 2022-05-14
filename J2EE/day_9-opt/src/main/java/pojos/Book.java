package pojos;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
	// Properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 5)
	private int id;
	
	@Column(length = 20, unique = true)
	private String title;

	@Column(length = 20)
	private String author;
	
	@Enumerated(value = EnumType.STRING)
	@Column(length = 20)
	private Category category;
	
	private double price;
	
	// --------------------------------------------------
	// changes after table creation (hbm2ddl = update)
//	 alter table Books 
//    add column test_property varchar(255)
	/*
	 * @Column(name = "test_property") private String testProperty;
	 * 
	 * public String getTestProperty() { return testProperty; }
	 * 
	 * 
	 * public void setTestProperty(String testProperty) { this.testProperty =
	 * testProperty; }
	 */
	// After removing table not altered
	// --------------------------------------------------

	// Constructors
	public Book() {
	}
	

	// Getter setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
