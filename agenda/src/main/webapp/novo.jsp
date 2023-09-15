<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="teste.Controller" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="scripts/validador.js"></script>
<body>
	<h1>Criar novo contato</h1>
	<form name="frmContato" action="">
		<table>
			<tr>
				<td><input type="text" name="nome" placeholder="Nome"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" placeholder="Telefone"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" placeholder="E-mail"></td>
			</tr>
			


		</table>
		<input type="submit" value="Ok" onclick="validador()" >
		<input type="reset" value="Cancelar" id="btnCancelar">
		
	</form>
	
	<%
		Controller t = new Controller();
		
		String paramNome = request.getParameter("nome");
		String paramFone = request.getParameter("fone");
		String paramEmail = request.getParameter("email");
		
		if((paramNome != null) && (paramFone) != null){
			
			t.adicionar(paramNome, paramFone, paramEmail);
		
		}
	%>
	
</body>
</html>