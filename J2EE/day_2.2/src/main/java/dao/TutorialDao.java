package main.java.dao;

import static main.java.utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.pojos.Tutorial;

public class TutorialDao implements ITutorialDao, AutoCloseable {

	private Connection connection;
	private PreparedStatement psGetTutorialsByTopicId;
	private PreparedStatement psGetTutorialByTutorialName;
	private PreparedStatement psVisitATutorial;
	private PreparedStatement psGetTutorialVisits;

	public TutorialDao() throws SQLException {
		// get Connection
		this.connection = getConnection();

		// Prepare Statement
		psGetTutorialsByTopicId = connection.prepareStatement("select * from tutorials where topic_id = ? order by visits desc");
		psGetTutorialByTutorialName = connection.prepareStatement("select * from tutorials where name = ?");
		psVisitATutorial = connection.prepareStatement("update tutorials set visits = visits + 1 where id = ?");
		psGetTutorialVisits = connection.prepareStatement("select visits from tutorials where id = ?");
	}

	@Override
	public List<Tutorial> getTutorialsByTopicId(int topicId) throws SQLException {
		// Add parameters to statement
		psGetTutorialsByTopicId.setInt(1, topicId);

		// Create a list to store all tutorial
		List<Tutorial> list = new ArrayList<Tutorial>();

		// Execute query
		try (ResultSet rs = psGetTutorialsByTopicId.executeQuery()) {
			while (rs.next()) {
				// Create a tutorial object to store a tutorial
				Tutorial tutorial = new Tutorial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7));

				// Add tutorial to list
				list.add(tutorial);
			}
		}

		return list;
	}

	@Override
	public Tutorial getTutorialByTutorialName(String name) throws SQLException {
		// Add parameters to statement
		psGetTutorialByTutorialName.setString(1, name);

		// Create a tutorial object to store a tutorial
		Tutorial tutorial = null;

		// Execute Query
		try (ResultSet rs = psGetTutorialByTutorialName.executeQuery()) {
			if (rs.next())
				tutorial = new Tutorial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7));
		}

		return tutorial;
	}

	@Override
	public int visitATutorial(int tutorialId) throws SQLException {
		// Add parameters to statement
		psVisitATutorial.setInt(1, tutorialId);
		psGetTutorialVisits.setInt(1, tutorialId);
		
		// Execute Queries
		// Visit Tutorial
		psVisitATutorial.executeUpdate();
		
		// Get Updated Visits
		int result = 0; 
		try (ResultSet rs = psGetTutorialVisits.executeQuery()) {
			if (rs.next())
				result = rs.getInt(1);
		}
		
		return result;
	}

	@Override
	public void close() throws Exception {
		// Close all statements
		if (psGetTutorialsByTopicId != null)
			psGetTutorialsByTopicId.close();

		if (psGetTutorialByTutorialName != null)
			psGetTutorialByTutorialName.close();

		if (psVisitATutorial != null)
			psVisitATutorial.close();

		if (psGetTutorialVisits != null)
			psGetTutorialVisits.close();

	}

}
