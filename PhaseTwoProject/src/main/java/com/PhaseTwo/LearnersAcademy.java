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

	}

}
// first thing we need jdbc driver to connect sql with our java project