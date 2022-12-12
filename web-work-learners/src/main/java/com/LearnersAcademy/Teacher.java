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

	private Integer teacherId;
	private String  teacherName;
	private String  subject;
	private Integer numberOfClasses;
	private String  classId;
	
	List<Teacher> teacherList = new ArrayList<>();
	
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
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
	public Integer getNumberOfClasses() {
		return numberOfClasses;
	}
	public void setNumberOfClasses(Integer numberOfClasses) {
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
	

	public Teacher(Integer teacherId, String teacherName, String subject, Integer numberOfClasses, String classId) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.subject = subject;
		this.numberOfClasses = numberOfClasses;
		this.classId = classId;
	//	this.teacherList = teacherList;
	}
	public List<Teacher> getTeachersList() throws SQLException {
		Connection dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
		String qry = "SELECT * FROM teachers";
		try {
			Statement theStatment = dbCon.createStatement();
			resultSet = theStatment.executeQuery(qry);
			while (resultSet.next()) {

				teacherList.add(new Teacher(resultSet.getInt("teacher_ID")
						,resultSet.getString("teacher_name")
						,resultSet.getString("subjects")
						,resultSet.getInt("number_of_classes")
						,resultSet.getString("class_ID")));
//				
				
			}
			dbCon.close(); // close connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacherList;
	}
	

	

}
