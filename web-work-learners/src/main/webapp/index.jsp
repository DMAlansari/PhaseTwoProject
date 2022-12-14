<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="com.LearnersAcademy.DataBase"%>
<%@ page import="com.LearnersAcademy.Student"%>
<%@ page import="com.LearnersAcademy.Teacher"%>
<%@ page import="com.LearnersAcademy.Classes"%>
<%@ page import="com.LearnersAcademy.Subjects"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style><%@include file="/style.css"%></style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section class="login">
<%
response.setContentType("text/html");

new DataBase().met();
DataBase studentObject = new DataBase();
Student studentList = new Student();
List<Student> students = new ArrayList<>();
students.clear();
students = studentList.getStudentList();

Teacher teacherList = new Teacher();
List<Teacher> teachers = new ArrayList<>();
teachers = teacherList.getTeachersList();

Classes classesList = new Classes();
List<Classes> classes = new ArrayList<>();
classes = classesList.getClassesList();

Subjects subjectList = new Subjects();
List<Subjects> subjects = new ArrayList<>();
subjects = subjectList.getSubjectList();
%>

 
    

<div class="tables">
<table class= "bigtabell" cellspacing="5" cellpadding="0" width="1318" bgcolor="#76320a">
    <tr>
        <td width="200" bgcolor="white" class="bigTabletd">
            <!-- write here -->
             <table>
    <thead>
        <tr>
            <th class="tHeader1" width="300" bgcolor="#76320a"  colspan="4">Students</th>
        </tr>
    </thead>
    <tbody class="Selement">
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
    <td class="Sselement"><%=s.getGrade()%></td>
    <%} %>
  </tr>
    </tbody>
</table>
        </td>
        <td  width="768" bgcolor="white" class="bigTabletd">
           <!-- write here -->
            <table>
    <thead>
        <tr>
            <th class="tHeader2" width="1200" bgcolor="#76320a" colspan="4">Teachers</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th class="tCol">Teacher ID  </th>
            <th class="tCol">Teacher Name  </th>
            <th class="tCol">Subjects  </th>
            <th class="tCol">Number of Classes</th>
            <th class="tCol">Class ID</th>
        </tr>
         <% for(Teacher t: teachers){
        	 %>
         <tr class = "teachElements">
          
    <td class="Telement"><%=t.getTeacherId()%></td>
    <td class="Telement"><%=t.getTeacherName()%></td>
    <td class="Telement"><%=t.getSubject()%></td>
    <td class="Teelement"><%=t.getNumberOfClasses()%></td>
      <td><%=t.getClassId()%></td>
    <%} %>
  </tr>
    </tbody>
</table>
        </td>
        <td width="300" bgcolor="white" class="bigTabletd">
           <!-- write here -->
           <table>
    <thead>
        <tr>
        
            <th  class="tHeader" width="300" bgcolor="#76320a"  colspan="4">  Classes  </th>
            
        </tr>
    </thead>
    <tbody class="classes">
    <div class="table-header">
        <tr class="colomns">
            <th class="col1">Classes</th>
            <th class="col2">Capacity</th>
            <th class="col3">Grade</th>
        </tr>
        </div>
         <% for(Classes c: classes){
        	 %>
         <tr class="elements">
          
    <td ><%=c.getClassId()%></td>
    <td class="cells"><%=c.getCapacity()%></td>
    <td ><%=c.getGrade()%></td>
 
    <%} %>
  </tr>
    </tbody>
    
     </table>
        </td>
    </tr>
</table>
</div>
<div class="addstudent"><form action="getStudent.jsp" >
<INPUT  TYPE="Text" name="StudentID" placeholder="Student Id">
<INPUT  TYPE="Text" name="StudentName" placeholder="Student Name">
<INPUT  TYPE="Text" name="ClassID" placeholder="Class">
<INPUT  TYPE="Text" name="Grade" placeholder="Grade">

<INPUT class="submit1" TYPE="Submit" Value="Add Student">
</form>
<form action="getTeacher.jsp" >
<INPUT  TYPE="Text" name="teacherID" placeholder="Teacher Id">
<INPUT  TYPE="Text" name="teacherName" placeholder="Teacher Name">
<INPUT  TYPE="Text" name="Subject" placeholder="Subject">
<INPUT  TYPE="Text" name="NumberOfClasses" placeholder="Number of Classes">
<INPUT  TYPE="Text" name="ClassID" placeholder="Classes">
<INPUT class="submit2" TYPE="Submit" Value="Add Teacher">
</form>
</div>
  
<table class= "ThirdTable" cellspacing="5" cellpadding="0" width="1318" bgcolor="#76320a">
    <tr>
        <td width="200" bgcolor="white" class="bigTabletd">
     <table>
    <thead>
        <tr>
            <th class="thHeader" width="2000" bgcolor="#76320a"  colspan="4">Subjects</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>Subject</th>
            <th class="techerC">Teacher</th>
            <th>Classes</th>
        </tr>
         <% for(Subjects su: subjects){
        	 %>
         <tr>
          
    <td class="thElement1"><%=su.getSubject()%></td>
    <td class="thElement2"><%=su.getTeacher()%></td>
    <td class="thElement3"><%=su.getClassId()%></td>
 
    <%} %>
  </tr>
    </tbody>
</table>
<div class="assign">
<form action= "assignTeacher.jsp">
<label>assign a Teacher</label>

<select name= "assignTeacher">

<%
response.setContentType("text/html");
for(Teacher t: teachers){
	out.print("<option>" + t.getTeacherName() + "</option>");}
%>
</select>

<label>for a class</label>

<select name="forClass">
<%
response.setContentType("text/html");
for(Classes c: classes){
	out.print("<option>" + c.getClassId() + "</option>");}
%>
</select>

<label>for subject</label>

<select name="forSubject">
<%
response.setContentType("text/html");
for(Subjects su: subjects){
	out.print("<option>" + su.getSubject() + "</option>");}
%>
</select>
<INPUT class="submit" TYPE="Submit" Value="assign">
</form>
</div>
    </tr>
</table>



</body>
</html>