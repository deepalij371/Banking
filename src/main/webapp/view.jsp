<%@ page import="bankProject.AccountBean" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
</head>
<body>
<% 
AccountBean ab = (AccountBean) request.getAttribute("data");
if (ab != null) { 
%>
<table border="1">
    <tr>
        <td><%= ab.getName() %></td>
        <td><%= ab.getPassword() %></td>
        <td><%= ab.getAmount() %></td>
        <td><%= ab.getAddress() %></td>
        <td><%= ab.getPhone() %></td>
        
    </tr>
</table>
<% 
} else { 
%>
<table border="1">
    <tr>
        <td colspan="5">Data not available</td>
    </tr>
</table>
<% 
} 
%>
</body>
</html>
