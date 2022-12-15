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
<div class="errorMSG">
<%
String msg = request.getParameter("message");
String error = request.getParameter("error");

if(error!=null){
	out.println(msg);
}
%></div>
<section class="login">
<div class="loginbox">
<div class="left">
<div class="contact">
<div class="photo"><img src="newlogo.jfif" alt=""></div>
<form action="validate.jsp">
	
EMAIL<input type="text" name="email"/><br/><br/>  
PASSWORD<input type="password" name="password"/><br/><br/>  
<button class="submit" type="submit">LOGIN</button>
</form> 
</div>
</div>
</div>
</section> 
</body>
</html>