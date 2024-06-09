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
AccountBean ab1 = (AccountBean) request.getAttribute("data");
if (ab1 != null) {
%>
<table border="1">
    <tr>
        <td>Account</td>
        <td>Name</td>
        <td>Amount</td>
        <td>Address</td>
        <td>Phone</td>
    </tr>
    <tr>
        <td><%= ab1.getAccount() %></td>
        <td><%= ab1.getName() %></td>
        <td><%= ab1.getAmount() %></td>
        <td><%= ab1.getAddress() %></td>
        <td><%= ab1.getPhone() %></td>
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
