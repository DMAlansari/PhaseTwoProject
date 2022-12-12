package com.Learners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
public class Academy {
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/learners_academy";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";

	static private Connection dbCon;

	private static String qry;

	private static Statement theStatement;

	private static ResultSet resultSet;

	public static void main(String[] args) {
		

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
