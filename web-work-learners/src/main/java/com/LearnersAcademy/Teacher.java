package com.LearnersAcademy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Teacher {
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/learners_academy";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	static private Connection dbCon;
	private static String qry;
	private static Statement theStatement;
	private static ResultSet resultSet;

	private String teacherId;
	private String teacherName;
	private String subject;
	private String numberOfClasses;
	private String classId;

	List<Teacher> teacherList = new ArrayList<>();

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getNumberOfClasses() {
		return numberOfClasses;
	}

	public void setNumberOfClasses(String numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

//	List<Teacher> teacherList = new ArrayList<>();
//	
	public Teacher() {

	}

	public Teacher(String teacherId, String teacherName, String subject, String numberOfClasses, String classId) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.subject = subject;
		this.numberOfClasses = numberOfClasses;
		this.classId = classId;
		// this.teacherList = teacherList;
	}

	public List<Teacher> getTeachersList() throws SQLException {
		teacherList.clear();
		Connection dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
		String qry = "SELECT * FROM teachers";
		try {
			Statement theStatment = dbCon.createStatement();
			resultSet = theStatment.executeQuery(qry);
			while (resultSet.next()) {

				teacherList.add(new Teacher(resultSet.getString("teacher_ID"), resultSet.getString("teacher_name"),
						resultSet.getString("subjects"), resultSet.getString("number_of_classes"),
						resultSet.getString("class_ID")));
			}
			dbCon.close(); // close connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teacherList;
	}

	public void addTeacher(String teacherId, String teacherName, String subject, String numberOfClasses, String classId)
			throws SQLException {

		Connection dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
		theStatement = dbCon.createStatement();
		qry = String.format(
				"INSERT INTO `teachers`(`teacher_ID`, `teacher_name`, `subjects`, `number_of_classes`, `class_ID`)"
						+ " VALUES ('%s','%s','%s','%s','%s')",
				teacherId,teacherName, subject, numberOfClasses, classId);

		if (theStatement.executeUpdate(qry) > 0)
			System.out.println("A new teacher is added to the list.");
		else
			System.out.println("failed adding a teacher");
	}
	
	public void asignTeacher(String teacherName, String classId, String subject) throws SQLException {
		// Assign classes for subjects from the master list

		Connection dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
		theStatement = dbCon.createStatement();
		qry = String.format(
				"UPDATE `subjects` SET `class_ID`='%s',`teacher_name`='%s' WHERE `subject`='%s';",classId, teacherName, subject);
System.out.println(qry);
		if (theStatement.executeUpdate(qry) > 0)
			System.out.println("Teacher " + teacherName + " is assign to class " + classId + "for subject: " + subject);
		else
			System.out.println("failed assigning a teacher");

	}

}
