<%-- 
    Document   : order
    Created on : 5 Jan, 2022, 10:38:08 PM
    Author     : MD SARFRAZ ALAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="background-color: pink">
        <h1>Your Order have been Placed</h1>
        <h2>Wait.... Your food is being prepared</h2>
        <% int r1=Integer.parseInt(request.getParameter("rice"));%>
        <% int s1=Integer.parseInt(request.getParameter("sandwitch"));%>
        <% int m1=Integer.parseInt(request.getParameter("maggie"));%>
        <% int c1=Integer.parseInt(request.getParameter("chapati"));%>
        <% int s=(r1*30)+(c1*10)+(s1*15)+(m1*10); %>
        <h1>Your Have ordered :<%=r1%> plate rice</h1>
        <h1>Your have ordered :<%=c1 %> chapati</h1>
        <h1>Your Have ordered :<%=m1%> bowl of maggie</h1>
        <h1>Your have ordered :<%=c1 %> sandwitch</h1>
        <h1>Your Total Bill is Rs:<%=s %></h1>
       </div>
       <div style="background-color: yellowgreen"> <h1>Thanks You Visit again...</h1></div>>
    </body>
</html>
