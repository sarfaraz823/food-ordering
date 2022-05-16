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
    <body style="background-color: #85F4FF;">
        <div style="background-color: pink">
        <h1>Your Order have been Placed</h1>
        <h2>Wait.... Your food is being prepared</h2>
        <% int b1=Integer.parseInt(request.getParameter("biryani"));%>
        <% int f1=Integer.parseInt(request.getParameter("fish"));%>
        <% int r1=Integer.parseInt(request.getParameter("rice"));%>
        <% int c1=Integer.parseInt(request.getParameter("chapati"));%>
        <% int s=(r1*30)+(c1*10)+(b1*70)+(f1*10); %>
        <h1>Your Have ordered :<%=r1%> plate rice</h1>
        <h1>Your have ordered<%=c1 %> chapati</h1>
        <h1>Your Have ordered :<%=b1%> plate biryani</h1>
        <h1>Your have ordered<%=f1 %> fish</h1>
        <h1>Your Total Bill is Rs:<%=s %></h1>
       </div>
       <div style="background-color: yellowgreen"> <h1>Thanks You Visit again...</h1></div>>
    </body>
</html>
