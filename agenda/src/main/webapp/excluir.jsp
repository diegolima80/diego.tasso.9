<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="teste.Controller"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<scripts src="scripts/confirmador.js"></scripts>
<body>
<div onload="toAgenda()">
<% 
	Controller c = new Controller();
	String paramIdcon = request.getParameter("delete_idcon");
	
	if (paramIdcon != null && paramIdcon != ""){
	c.excluir(paramIdcon);
	}
	
	
%>
</div>
</body>
</html>