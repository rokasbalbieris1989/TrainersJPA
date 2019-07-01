<%-- 
    Document   : updatetrainer
    Created on : Jun 30, 2019, 5:33:58 PM
    Author     : me
--%>

<%@page import="entities.Trainer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Title</title>
    </head>
    <body>
        <h1>${title}</h1> 
        <%! Trainer tr ; %>
        <% tr=(Trainer) request.getAttribute("trainer");%>
        <form method="POST" action="UpdateTrainer?update=<%=tr.getId()%>">
            Enter New Name     : <input name="name" type="text" placeholder="<%=tr.getName()%>"/><br>
            Enter New Surname  : <input name="surname" type="text" placeholder="<%=tr.getSurname()%>" /><br>
            Enter New Subject    : <input name="grade" type="number" placeholder="<%=tr.getSubject()%>"/><br>
            <input type="submit" name="update" value="Update Trainer" />
    </body>
</html>
