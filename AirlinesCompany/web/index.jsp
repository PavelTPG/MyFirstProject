<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login Application</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            <fieldset style="width: 500px ">
                <legend> Login to App </legend>
                <table>
                    <tr>
                        <td>Login</td>
                        <td><input type="text" name="username"  /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="userpass"  /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Enter" /></td>

                    </tr>
                </table>

            </fieldset>
            <tr>
                <td><input type="submit" name="registration.jsp"value="Registration" /></td>
            </tr>
        </form>
    </body>
</html>