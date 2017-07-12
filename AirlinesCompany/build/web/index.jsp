<%-- 
    Document   : index
    Created on : Jul 6, 2017, 11:52:57 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 > <center>Welcome!</center></h1>
        <form  method="post" action="hello">
            <style type="text/css">
                mypanel{width: 150px; height: 80px;}
            </style>
            <div class="mypanel">    
            Login:   <input type="text" name ="login" value=""/> <br>
            Password: <input type="password" name="password" value=""/> <br>
            <input type="submit" name="Loading"/>
            <input type="reset"/> <br>
            <input type="file"/>
            </div>
        </form>
    </body>
</html>
