<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome <%=session.getAttribute("name")%></title>
    </head>
    <body>
        <h3>Login successful!!!</h3>
        <h4>
            Hello,
            <%=session.getAttribute("name")%></h4>
            <form>
    <tr>
        <td><input type="submit"name="plane.jsp" value="list Plane" /></td>
       </tr>
       </form>
</body>
</html>