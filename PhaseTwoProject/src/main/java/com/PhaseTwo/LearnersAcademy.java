package com.PhaseTwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LearnersAcademy {

	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/learners_academy";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";

	static private Connection dbCon;

	private static String qry;

	private static Statement theStatement;

	private static ResultSet resultSet;

	public static void main(String[] args) throws SQLException {

		try {
//			Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

//			Try to establish the connection
			dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);

//Get a reference to the Statement
			theStatement = dbCon.createStatement();

		} catch (ClassNotFoundException e) {
			System.out.println("Can't load the driver : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Can't connect, some issues  : " + e.getMessage());
		}
// adding a student to student list AND printing the list-----------------------------------------------------------------------------
		// studentList("10003","Bader Almansour", "10/1", 10);
// only printing the student list-----------------------------------------------------------------------------------------------------
		// getStudentList();
// adding a new teacher --------------------------------------------------------------------------------------------------------------
		// teacherList("Aljazy Alenzi","Biology12",4,"12/1 - 12/2 - 13/3 - 12/4");
// Only printing teachers list
		 getTeachersList();

// assigning a class to a subject ----------------------------------------------------------------------------------------------------
//		asignClass("10/4", "Science10");
		
//      Only prints classes with their subjects
//		getClassesList("10/4");
		
//Assigning a teacher for a class and a subject --------------------------------------------------------------------------------------
//		asignTeacher("10/1", "Arabic10", "Farhan alfarhan");
	}

	static void studentList(String studentId, String studentName, String classId, Integer grade) throws SQLException {

		qry = String.format("INSERT INTO `students` (`student_ID`, `student_name`, `class_ID`, `grade`) "
				+ "VALUES ('%s', '%s', '%s', '%d');", studentId, studentName, classId, grade);

//		Execute the query
		if (theStatement.executeUpdate(qry) > 0)
			System.out.println("A new student is added to the list.");
		else
			System.out.println("failed adding a student");

		getStudentList();

	}

	public static void getStudentList() {
		qry = "SELECT * FROM students";
		try {
			Statement theStatment = dbCon.createStatement();
			resultSet = theStatment.executeQuery(qry);
			while (resultSet.next()) {
				System.out.print("Student ID: " + resultSet.getString("student_ID") + " ");
				System.out.print("Student Name: " + resultSet.getString("student_name"));
				System.out.print(" In " + resultSet.getString("grade") + "th grade");
				System.out.println(" at class: " + resultSet.getString("class_ID"));
			}
			dbCon.close(); // close connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void teacherList(String teacherName, String subject, Integer nClasses, String classId) throws SQLException {
		qry = String.format(
				"INSERT INTO `teachers`(`teacher_ID`, `teacher_name`, `subjects`, `number_of_classes`, `class_ID`)"
						+ " VALUES (null,'%s','%s',%d,'%s')",
				teacherName, subject, nClasses, classId);

		if (theStatement.executeUpdate(qry) > 0)
			System.out.println("A new teacher is added to the list.");
		else
			System.out.println("failed adding a teacher");

		getTeachersList();

	}

	static void getTeachersList() {
		String qry = "SELECT * FROM teachers";
		try {
			Statement theStatment = dbCon.createStatement();
			resultSet = theStatment.executeQuery(qry);
			while (resultSet.next()) {
				System.out.print("teacher's ID: " + resultSet.getString("teacher_ID") + " ");
				System.out.print("teacher's Name: " + resultSet.getString("teacher_name") + " subjects: ["
						+ resultSet.getString("subjects"));
				System.out.print("] teaches " + resultSet.getString("number_of_classes") + " classes: [");
				System.out.println(resultSet.getString("class_ID") + "]");
			}
			dbCon.close(); // close connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void asignClass(String classId, String subject) throws SQLException { // change the qry to update to assign a class to a subject
		// Assign classes for subjects from the master list
		qry = String.format(
				"INSERT INTO `subjects` (`class_ID`, `subject`, `teacher_name`) " + "VALUES ('%s', '%s', '');", classId,
				subject);

		if (theStatement.executeUpdate(qry) > 0)
			System.out.println("Class " + classId + " is assign to subject " + subject);
		else
			System.out.println("failed assigning a class to a subject");

		getClassesList(classId);

	}

	static void getClassesList(String classId) { 

		qry = String.format("SELECT `class_ID`, `subject` FROM `subjects` WHERE class_ID ='%s'",classId);

		System.out.print("Class : " + classId + " is assign to subjects: [ ");
		try {
			Statement theStatment = dbCon.createStatement();
			resultSet = theStatment.executeQuery(qry);
			// System.out.print("Class : "+resultSet.getString("class_ID") + " ");
			while (resultSet.next()) {

				// System.out.print("Class : "+resultSet.getString("class_ID") + " ");
				System.out.print(resultSet.getString("subject") + " ");

			}
			System.out.println("]");
			dbCon.close(); // close connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void asignTeacher(String classId, String subject, String teacher) throws SQLException {
		// Assign classes for subjects from the master list
		System.out.println("inside the method");
		qry = String.format(
				"UPDATE `subjects` SET `teacher_name`='%s' WHERE subject = '%s' AND class_ID = '%s';", teacher, subject, classId);

		if (theStatement.executeUpdate(qry) > 0)
			System.out.println("Teacher " + teacher + " is assign to class " + classId + "for subject: " + subject);
		else
			System.out.println("failed assigning a teacher");


	}
	
	
 public void connection() {
		try {
//			Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

//			Try to establish the connection
			dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);

//Get a reference to the Statement
			theStatement = dbCon.createStatement();

		} catch (ClassNotFoundException e) {
			System.out.println("Can't load the driver : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Can't connect, some issues  : " + e.getMessage());
		}
 }
}
// first thing we need jdbc driver to connect sql with our java project