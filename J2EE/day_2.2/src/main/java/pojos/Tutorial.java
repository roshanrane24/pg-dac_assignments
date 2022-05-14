package main.java.pojos;

import java.sql.Date;

public class Tutorial {
	private int id;
	private String name;
	private String author;
	private Date publishedDate;
	private int visits;
	private String content;
	private int topicId;
	
	public Tutorial() {
	}

	public Tutorial(int id, String name, String author, Date publishedDate, int visits, String content, int topicId) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publishedDate = publishedDate;
		this.visits = visits;
		this.content = content;
		this.topicId = topicId;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
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

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	
}
