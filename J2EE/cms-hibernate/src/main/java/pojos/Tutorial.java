package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial extends BaseEntity {
	private String name;
	private String author;
	
	@Column(name = "publish_date")
	private LocalDate publishedDate;
	
	private int visits;
	
	@Column(name = "contents")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;

	public Tutorial() {
	}

	public Tutorial(String name, String author, LocalDate publishedDate, int visits, String content) {
		this.name = name;
		this.author = author;
		this.publishedDate = publishedDate;
		this.visits = visits;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	// To String
	@Override
	public String toString() {
		return "Tutorial [Id=" + getId() + ", name=" + name + ", author=" + author + ", publishedDate=" + publishedDate + ", visits="
				+ visits + ", content=" + content + "]";
	}

}
