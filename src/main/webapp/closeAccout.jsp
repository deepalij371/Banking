<%@ page import="bankProject.AccountBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AccountBean ab2=(AccountBean)request.getAttribute("close");
if(ab2!=null){
%>
<p><strong>Account Number:</strong><%= ab2.getAccount()%></p>
<p><strong>Account NAme:</strong><%=ab2.getName() %></p>
<%
} else{
%>
<p>Error:Account details are not available.</p>
<%
}
%>
<a href="home.html">NEW ACCOUNT</a><br><br>
</body>
</html>