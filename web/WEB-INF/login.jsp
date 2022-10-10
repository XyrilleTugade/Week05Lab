<%-- 
    Document   : login
    Created on : Oct 9, 2022, 4:57:42 PM
    Author     : Xyrille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="login" method="post">
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Log in">
        </form>
        ${invalidMessage}
    </body>
</html>
