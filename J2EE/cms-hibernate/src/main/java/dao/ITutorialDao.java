package dao;

import java.util.List;

import pojos.Tutorial;

public interface ITutorialDao {
	void addTutorial(Tutorial tutorial, int topicId);
	// ------------------------------ Read ------------------------------
	// Get tutorial by topic id
	List<Tutorial> getTutorialsByTopicId(int topicId);
	// Get Tutorial by tutorial name
	Tutorial getTutorialByTutorialName(String name);
	
	// ----------------------------- Update -----------------------------
	// Add a visit to tutorial
	int visitATutorial(int tutorialId);
}
