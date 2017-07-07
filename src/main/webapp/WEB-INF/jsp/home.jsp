<%-- 
    Document   : home
    Created on : Jul 7, 2017, 9:06:10 PM
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World !</h1>
        
        <c:forEach var="contact" items="${listContact}" varStatus="status">
            
                <tr>
                    <td>${contact.getId()}</td>
                    <td>${contact.name}</td>
                </tr>
                </c:forEach>      

    </body>
</html>
