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
String teacherName = request.getParameter("assignTeacher");
String classId = request.getParameter("forClass");
String subject     = request.getParameter("forSubject");

Teacher object = new Teacher();

object.asignTeacher(teacherName, classId, subject);
//object.addTeacher(teacherId, teacherName, subject, numberOfClasses, classId);

%>
<jsp:forward page = "index.jsp"></jsp:forward>
</body>
</html>