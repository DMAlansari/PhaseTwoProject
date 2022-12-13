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
String email = request.getParameter("email");
String password = request.getParameter("password");

if(email.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("1234567")){
	%><jsp:forward page = "index.jsp"></jsp:forward><% 
}else{
	 %> <jsp:forward page="login.jsp">
    <jsp:param name="message" value="Invalid email or password!"/>
    <jsp:param name="error" value="-1"/>
</jsp:forward> <%}; %>


</body>
</html>