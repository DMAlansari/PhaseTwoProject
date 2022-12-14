<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body style="background-color: #ECF6FE">

<div id="form-wrapper">
    <form method="post" id="Login" action="validateLogin.jsp">
        <table>
            <tr>
                <td>Enter userID:</td>
                <td><input type="text" name="userid"></td>
            </tr>

            <tr>
                <td>Enter password:</td>
                <td><input type="password" name="password"></td>
            </tr>

            <tr>
                <td><br> <input type="submit" value="Login" />  <input
                    type="reset" value="Cancel" /><br /></td>
            </tr>

        </table>


    </form>
</div>

<div></div>

<h6 align="center">Note! An admin operator must use "admin" as
    username and "masterkey" as password</h6>

</body>
</html>
