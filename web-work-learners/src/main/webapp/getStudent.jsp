<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.LearnersAcademy.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String studentId   = request.getParameter("StudentID");
String studentName = request.getParameter("StudentName");
String classId     = request.getParameter("ClassID");
String grade      = request.getParameter("Grade"); 

Student object = new Student();
object.addStudent(studentId, studentName, classId, grade);
%>

<jsp:forward page = "index.jsp"></jsp:forward>
</body>
</html>