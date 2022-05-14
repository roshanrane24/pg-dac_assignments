package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Tutorial;

public interface ITutorialDao {
	public void addTutorial(Tutorial tutorial) throws SQLException;
	// ------------------------------ Read ------------------------------
	// Get tutorial by topic id
	List<Tutorial> getTutorialsByTopicId(int topicId) throws SQLException;
	// Get Tutorial by tutorial name
	Tutorial getTutorialByTutorialName(String name) throws SQLException;
	
	// ----------------------------- Update -----------------------------
	// Add a visit to tutorial
	int visitATutorial(int tutorialId) throws SQLException;
}
