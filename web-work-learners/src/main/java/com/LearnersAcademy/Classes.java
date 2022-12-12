package com.LearnersAcademy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Classes {
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/learners_academy";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	static private Connection dbCon;
	private static String qry;
	private static Statement theStatement;
	private static ResultSet resultSet;

	private String classId;
	private Integer capacity;
	private Integer grade;
	
	

	List<Classes> classList = new ArrayList<>();

	public Classes() {

	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Classes(String classId, Integer capacity, Integer grade) {
		super();
		this.classId = classId;
		this.capacity = capacity;
		this.grade = grade;
	}

	public List<Classes> getClassesList() throws SQLException {
		Connection dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
		String qry = "SELECT * FROM classes";
		try {
			Statement theStatment = dbCon.createStatement();
			resultSet = theStatment.executeQuery(qry);
			while (resultSet.next()) {
				classList.add(new Classes(resultSet.getString("class_ID"), resultSet.getInt("capacity"),
						resultSet.getInt("grade")));
			}
			dbCon.close(); // close connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return classList;
	}

}
