package com.MyFirst.SpringProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.BufferedReader;
public class Bank {
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/first_database";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "";
	static private Connection dbCon;
	private static String qry;
	private static Integer balance;
	private static Statement theStatement;
	private static ResultSet resultSet;
	public static void main(String[] args) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // load the driver , for each sql it is different
			dbCon = DriverManager.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);
			theStatement = dbCon.createStatement(); // Don't initialize the connection in here it is better to initialize it on a different class
			System.out.println("Successfully connected to the database...");
		} catch (ClassNotFoundException e) {
			System.out.println("Cant load the driver :" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Cant connect som issues: " + e.getMessage());
		}
		String name, account, date,type;
		int balance, withdraw;
		Scanner scan = new Scanner(System.in);
		// ------------------------------------------------------------------------------ To create a new account
//		System.out.println("To create a new account add the customers type customer name :");
//		name = scan.nextLine();
//		System.out.println("account :");
//		account = scan.next();
//		System.out.println("balance :");
//		balance = scan.nextInt();
//		createAccount(name,account,balance);
		// ------------------------------------------------------------------------------ end of creating
		
		//------------------------------------------------------------------------------- withdraw
//		System.out.println("withdraw from :");
//		account = scan.next();
//		System.out.println("An amount of :");
//		withdraw= scan.nextInt();
//		scan.nextLine();
//		System.out.println("Date :");
//		date = scan.nextLine();
//		System.out.println("Type of transaction: ");
//		type = scan.nextLine();
		withdraw("456789123",60, "2022-12-05","withdraw");
	}

	static void createAccount(String name, String account, Integer balance ) throws SQLException {
		
		
		qry = String.format("INSERT INTO `bank`(`RIM_number`, `name`, `Accounts`, `Balance (KD)`) VALUES (null,'%s','%s',%d)", name, account,balance);
		
	//	System.out.println(qry);
		
//		Execute the query
		if(theStatement.executeUpdate(qry) > 0)
			System.out.println("A new account is opend...");
		else 
			System.out.println("failed creating an account");
		
	}
	static void printTransaction(String account) throws SQLException {
		qry = "select * from Transaction where Account = " + account ;
//		Execute the query
		resultSet = theStatement.executeQuery(qry);		

//		 Traverse through the resultSet
		while(resultSet.next()) {
			System.out.print(resultSet.getString("Transaction"));
			System.out.println(" On : " + resultSet.getString("Date"));
		}
	}
	

	
	static void withdraw(String account, Integer withdraw, String date, String type) throws SQLException {
		
//		 Traverse through the resultSet
//		qry="SELECT `Balance (KD)` FROM `bank` WHERE Accounts = '456789123'";
		qry = "select * from bank" ;
//		Execute the query
		resultSet = theStatement.executeQuery(qry);		
	//	System.out.print(resultSet.getInt("Balance (KD)"));
//		 Traverse through the resultSet
		while(resultSet.next()) {
			if(resultSet.getInt("Accounts")==456789123)
				balance = resultSet.getInt("Balance (KD)");
			
			//System.out.println(" On : " + resultSet.getString("Date"));
		}
		System.out.print(balance);
 //balance = resultSet.getInt("Balance (KD)");

	}
		
	
	
	
	
}
