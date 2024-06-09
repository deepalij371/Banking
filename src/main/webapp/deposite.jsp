<%@ page import="bankProject.AccountBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
</head>
<body>
<% 
AccountBean ab1 = (AccountBean) request.getAttribute("depos");
if (ab1 != null) {
%>
<table border="1">
    <tr>
        
        <td>Amount</td>
        
    </tr>
    <tr>
       
        <td><%= ab1.getAmount() %></td>
        
    </tr>
</table>
<% 
} else {
%>
<table border="1">
    <tr>
        <td>Data not available</td>
    </tr>
</table>
<% 
}
%>
</body>
</html>
