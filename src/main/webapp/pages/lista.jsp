<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="br.com.curso.model.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous">
</script>

<title>Curso Java Web - Listar Funcionario</title>
</head>
<body>
	<div align="center">
		<c:if test="${exclusao != null}">
			<p style="background: green; color: white;">${exclusao}</p>
		</c:if>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">Sobrenome</th>
					<th scope="col">Email</th>
					<th scope="col">Telefone</th>
				</tr>
			</thead>
			<c:forEach items="${funcionarios}" var="c">
				<tr>
					<td>${c.nome}</td>
					<td>${c.sobrenome}</td>
					<td>${c.email}</td>
					<td>${c.telefone}</td>
					<td>
						<a href="${pageContext.request.contextPath}/CadastrarFuncionarioController?id=${c.id}&action=editar">Editar</a> 
					    <a href="${pageContext.request.contextPath}/ListarFuncionarioController?id=${c.id}&action=excluir">Excluir</a>
					 </td>
				</tr>
			</c:forEach>
				
		</table>
	</div>

	<br />
	<br />
	<br />

	<div align="center">
		<a href="${pageContext.request.contextPath}/pages/cadastro.jsp">Cadastrar Funcionario</a>
		<a href="${pageContext.request.contextPath}/pages/index.jsp">Página Inicial</a>
	</div>
</body>
</html>