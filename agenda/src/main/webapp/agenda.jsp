<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="model.DAO"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="teste.Controller"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
#tabela {
	border-collapse: collapse;
}

#tabela th {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
	background-color: #55bbff;
	color: #fff;
}

#tabela td {
	border: 1px solid #ddd;
	padding: 10px;
}
a{text-decoration: 0;}
.botao{
width:160px;
height:40px;
border:1px solid #ddd;
background-color:#55bbff;
outline:none;
color:white;
  display: flex;
  justify-content: center;
  align-items: center;
  
}

</style>
</head>
<script src="scripts/confirmador.js"></script>
<script src="scripts/validador_editar.js"></script>
<body>
	<h1>Agenda</h1>
	<br>
	<a href="novo.jsp" class="botao"><div class="botao">Novo contato</div></a>
	<br>
	<table id="tabela" border=1>
		<thead>
			<tr>
				<th><center>Id</center></th>
				<th><center>Nome</center></th>
				<th><center>Telefone</center></th>
				<th><center>E-mail</center></th>
				<th></th>

			</tr>
		</thead>

		<tbody>

			<%
			JavaBeans jb = new JavaBeans();
			DAO dao = new DAO();
			ArrayList<JavaBeans> lista = dao.listar();

			String action = request.getParameter("tag");
			String paramIdcon2 = request.getParameter("idcon2");
			String paramNome2 = request.getParameter("nome2");
			String paramFone2 = request.getParameter("fone2");
			String paramEmail2 = request.getParameter("email2");

			// editar
			Controller t = new Controller();

			if (paramNome2 != null && paramFone2 != null && action != "editar") {
				t.editar(paramIdcon2, paramNome2, paramFone2, paramEmail2);
			}

			for (int i = 0; i < lista.size(); i++) {
			%>

			<form action="editar.jsp">
				<tr>
					<td><%=lista.get(i).getIdcon()%></td>
					<td><input name="nome" value="<%=lista.get(i).getNome()%>"
						style="border: none; width: 250px; outline: 0;"
						readonly="readonly"></td>
					<td><input name="fone" value="<%=lista.get(i).getFone()%>"
						style="border: none; width: 100px; outline: 0;"
						readonly="readonly"></td>
					<td><input name="email" value="<%=lista.get(i).getEmail()%>"
						style="border: none; width: 250px; outline: 0;"
						readonly="readonly"></td>
						
					<td>
						<input type="hidden" name="idcon" value="<%=lista.get(i).getIdcon() %>">
						<input type="submit" value="Editar">
						<input type="button" name="delete_idcon" value="Excluir" onclick="confirmar('<%=lista.get(i).getIdcon()%>')">
			</form>

			
			<input type="hidden" name="delete_idcon" >
			<input type="hidden" name="tag">




			</td>
			</tr>

			<%
			}
			%>

		</tbody>

	</table>





</body>
</html>