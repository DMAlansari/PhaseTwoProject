<%@page import="com.PhaseTwo.TestDb"%>
<%@page import="com.PhaseTwo.LearnersAcademy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	/* LearnersAcademy test = new LearnersAcademy();
	test.connection(); */
	/* test.connection();
	LearnersAcademy.getStudentList(); */
	TestDb  db = new TestDb();
	db.test();
	%>
</body>
</html>