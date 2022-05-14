package pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
	// Properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 5)
	private Integer id;
	
	@Column(length = 20, unique = true, nullable = false)
	private String title;

	@Column(length = 20, nullable = false)
	private String author;
	
	@Enumerated(value = EnumType.STRING)
	@Column(length = 20)
	private Category category;
	
	private double price;
	
	@Column(name = "available_stock")
	private int availableStock;
	
	@Column(name = "published_date")
	private LocalDate publishedDate;

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

	public int getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + ", price="
				+ price + ", availableStock=" + availableStock + ", publishedDate=" + publishedDate + "]";
	}
	
}
