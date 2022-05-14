package beans;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.TutorialDao;
import pojos.Tutorial;

public class TutorialBean {
	// Properties
	private int topicId;
	private String name;
	private String author;
	private String publishedDate;
	private String content;
	private Tutorial tutorial;
	
	// Error Message
	private String errorMessage;

	// Dependencies
	private TutorialDao tutorialDao;

	// Init
	public TutorialBean() throws SQLException {
		tutorialDao = new TutorialDao();
	}

	// getters & Setters
	public int getTopicId() {
		return topicId;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public String getContent() {
		return content;
	}

	public TutorialDao getTutorialDao() {
		return tutorialDao;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublishedDate(String date) {
		this.publishedDate = date;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTutorialDao(TutorialDao tutorialDao) {
		this.tutorialDao = tutorialDao;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	// BL :: validate tutorial details
	public String validateTutorial() throws SQLException {
		// Reset err message
		this.errorMessage = "";
		
		if (!validateDate()) {
			this.errorMessage = "Date must be with in six months";
			return "add_new_tutorial";
		} else if(!validateContent()) {
			this.errorMessage = "Content must be within 255 characters";
			return "add_new_tutorial";
		} else {
			insertNewTutorial();
			return "tutorial_added";
		}
	}

	private boolean validateDate() {
		return (LocalDate.parse(this.publishedDate).isAfter(LocalDate.now().minusMonths(6)));
	}

	private boolean validateContent() {
		return (this.content.length() < 255);
	}

	// DAO insert new tutorial
	private void insertNewTutorial() throws SQLException {
		// Create a tutorial object;
		Tutorial tutorial = new Tutorial();
		
		// Add tuttorial details
		tutorial.setName(name);
		tutorial.setAuthor(author);
		tutorial.setPublishedDate(LocalDate.parse(this.publishedDate));
		tutorial.setContent(content);
		
		// Add tutorial to database
		tutorialDao.addTutorial(tutorial, topicId);
		
	}

	//BL :: get all tutorials under topic
	public List<Tutorial> getTutorialsByTopic() throws SQLException {
		return tutorialDao.getTutorialsByTopicId(this.topicId);
	}
	
	// BL :: get tutorial by name
	public void getTutorialByName() throws SQLException {
		// get Tutorial
		this.tutorial = tutorialDao.getTutorialByTutorialName(this.name);
		
		// Add a visit
		tutorialDao.visitATutorial(tutorial.getId());
	}

}
