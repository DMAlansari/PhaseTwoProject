package com.MyFirst.SpringProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBase {
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/first_database";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	private static String qry;
	static private Connection dbCon;
	private static Statement theStatement;
	private static ResultSet resultSet;
	
	
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // load the driver , for each sql it is different
			dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
			theStatement = dbCon.createStatement();
			System.out.println("Successfully connected to the database...");
		} catch (ClassNotFoundException e) {
			System.out.println("Cant load the driver :" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Cant connect som issues: " + e.getMessage());
		}

		deleteById(11);
		getAllTrainees();
		Scanner scan = new Scanner(System.in);
		String name;
		int id;
		System.out.println("enter the name id of the trainee you wish to update and the updated name");
		System.out.println("ID: ");
		id = scan.nextInt();
		scan.nextLine(); // لازم احط هالخطوه ليش؟ لان سالي وليد
		System.out.println("Name: ");
		name = scan.nextLine();
		//updateTraineesName(id, name);

	}

	static void getAllTrainees() {
		String qry = "SELECT * FROM fursa";
		try {
			Statement theStatment = dbCon.createStatement();
			resultSet = theStatment.executeQuery(qry);
			while (resultSet.next()) {
				System.out.print(resultSet.getString("name") + " ");
				System.out.print("ID: " + resultSet.getString("RIM_Number"));
				System.out.println("  With skills" + resultSet.getString("Skills"));
			}
			dbCon.close(); // close connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void updateTraineesName(Integer id, String name) throws SQLException {
		
		qry = String.format("UPDATE fursa SET Name='%s' WHERE RIM_number = %d", name, id);
	//	qry = "UPDATE fursa SET Name ='" + name+ "' WHERE RIM_number ='" + id + "'";
				
		System.out.println(qry);
		
//		Execute the query
		if(theStatement.executeUpdate(qry) > 0)
			System.out.println("Trainee updated...");
	}
	
	static void deleteById(Integer id) throws SQLException {
		
		qry = String.format("DELETE FROM `fursa` WHERE RIM_number = %d", id);
	//	qry = "UPDATE fursa SET Name ='" + name+ "' WHERE RIM_number ='" + id + "'";
				
		System.out.println(qry);
		
//		Execute the query
		if(theStatement.executeUpdate(qry) > 0)
			System.out.println("Trainee deleted...");
	}
}
