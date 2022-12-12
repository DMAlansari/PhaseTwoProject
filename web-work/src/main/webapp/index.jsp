<%@ page import="com.LearnersAcademy.DataBase"%>
<%@ page import="com.LearnersAcademy.Student"%>
<%@ page import="com.LearnersAcademy.Teacher"%>
<%@ page import="com.LearnersAcademy.Classes"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Testing web...
<%
response.setContentType("text/html");

new DataBase().met();
DataBase studentObject = new DataBase();
Student studentList = new Student();
List<Student> students = new ArrayList<>();
students = studentList.getStudentList();

Teacher teacherList = new Teacher();
List<Teacher> teachers = new ArrayList<>();
teachers = teacherList.getTeachersList();

Classes classesList = new Classes();
List<Classes> classes = new ArrayList<>();
classes = classesList.getClassesList();

%>
<select name="Student">
 <%
 for(Student s: students){
 %>
 <option value ="<%= s %>"><%= s %></option>
               
            <%}%>
</select>
 <table>
    <thead>
        <tr>
            <th colspan="4">Students</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>Students Id  </th>
            <th>Student Name  </th>
            <th>Class Id  </th>
            <th>Grade  </th>
        </tr>
         <% for(Student s: students){
        	 %>
         <tr>
          
    <td><%=s.getStudentId()%></td>
    <td><%=s.getStudentName()%></td>
    <td><%=s.getClassId()%></td>
    <td><%=s.getGrade()%></td>
    <%} %>
  </tr>
    </tbody>
</table>

 <table>
    <thead>
        <tr>
            <th colspan="4">Teachers</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>Teacher ID  </th>
            <th>Teacher Name  </th>
            <th>Subjects  </th>
            <th>Number of Classes</th>
            <th>Class ID</th>
        </tr>
         <% for(Teacher t: teachers){
        	 %>
         <tr>
          
    <td><%=t.getTeacherId()%></td>
    <td><%=t.getTeacherName()%></td>
    <td><%=t.getSubject()%></td>
    <td><%=t.getNumberOfClasses()%></td>
      <td><%=t.getClassId()%></td>
    <%} %>
  </tr>
    </tbody>
</table>

 <table>
    <thead>
        <tr>
            <th colspan="4">Classes</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>Class</th>
            <th>Capacity</th>
            <th>Grade</th>
        </tr>
         <% for(Classes c: classes){
        	 %>
         <tr>
          
    <td><%=c.getClassId()%></td>
    <td><%=c.getCapacity()%></td>
    <td><%=c.getGrade()%></td>
 
    <%} %>
  </tr>
    </tbody>
</table>
</body>
</html>