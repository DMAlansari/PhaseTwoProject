package com.LearnersAcademy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Subjects {
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/learners_academy";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	static private Connection dbCon;
	private static String qry;
	private static Statement theStatement;
	private static ResultSet resultSet;

	private String subject;
	private String teacher;
	private String classId;

	List<Subjects> subjects = new ArrayList<>();

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	public Subjects() {
		
	}

	public Subjects(String subject, String teacher, String classId) {
		super();
		this.subject = subject;
		this.teacher = teacher;
		this.classId = classId;
	}
	
	public List<Subjects> getSubjectList() throws SQLException {
		Connection dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
		String qry = "SELECT * FROM subjects";
		try {
			Statement theStatment = dbCon.createStatement();
			resultSet = theStatment.executeQuery(qry);
			while (resultSet.next()) {
				subjects.add(new Subjects(resultSet.getString("subject"), resultSet.getString("teacher_name"),
						resultSet.getString("class_ID")));
			}
			dbCon.close(); // close connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return subjects;
	}
	
	
}
