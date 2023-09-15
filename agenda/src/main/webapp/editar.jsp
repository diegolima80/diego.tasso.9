<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

    <%@ page import="model.JavaBeans" %>
    <%@ page import="teste.Controller" %>
    <%@ page import="model.DAO" %>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<script src="scripts/validador_editar.js"></script>

<body>
	<h1>Editar contato</h1>
	<%
		Controller t = new Controller();
		
		String paramIdcon = request.getParameter("idcon");
	
		if (paramIdcon != null){
			t.listarContato(paramIdcon);
		}
		
		String paramNome = request.getParameter("nome");
		String paramFone = request.getParameter("fone");
		String paramEmail = request.getParameter("email");
		
	%>
	
	<form>
		
		<table>
			<tr>
				<td><input type="text" name="idcon" id="txtIdcon" readonly value="<%=paramIdcon %>" Style="background:silver; width:25px; border:none; outline:0;"></td>
			</tr>
			<tr>
				<td>Nome: <input type="text" name="nome2" id="txtNome" value="<%=paramNome %>"></td>
			</tr>
			<tr>
				<td>Telefone: <input type="text" name="fone2" id="txtFone" value="<%=paramFone %>"></td>
			</tr>
			<tr>
				<td>E-mail: <input type="text" name="email2" id="txtEmail" value="<%=paramEmail %>"></td>
			</tr>
			


		</table>
		<input type="button" value="Salvar" onclick="editar()">
		<input type="reset" value="Cancelar" id="btnCancelar">

		
		
	</form>
	

			


</body>
</html>