<%-- 
    Document   : addtrainer
    Created on : Jun 30, 2019, 5:33:37 PM
    Author     : me
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert new Trainer</title>
    </head>
    <body>
        <!--<h1>Insert new Student</h1>-->
        <h1><%=request.getAttribute("title")%></h1>
        <form method="POST" action="InsertTrainer">
            Name     : <input name="name" type="text" /><br>
            Surname  : <input name="surname" type="text" /><br>
            Subject    : <input name="subject" type="text" /><br>
            <input type="submit" name="new" value="New Trainer" />

        </form>
    </body>
</html>
