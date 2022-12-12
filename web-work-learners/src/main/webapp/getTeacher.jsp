<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.LearnersAcademy.Teacher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String teacherId   = request.getParameter("teacherID");
String teacherName = request.getParameter("teacherName");
String subject     = request.getParameter("Subject");
String numberOfClasses      = request.getParameter("NumberOfClasses"); 
String classId = request.getParameter("ClassID");

Teacher object = new Teacher();

object.addTeacher(teacherId, teacherName, subject, numberOfClasses, classId);

%>

<jsp:forward page = "index.jsp"></jsp:forward>
</body>
</html>