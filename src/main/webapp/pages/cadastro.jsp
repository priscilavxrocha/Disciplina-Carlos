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

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Cadastrar Funcionario</title>
</head>
<body>
	<div align="center">
		<form id="form" action="${pageContext.request.contextPath}/CadastrarFuncionarioController" method="post">
			<label>Nome:</label>
			<input name="nome" value="${funcionario.nome}"> <br>
			
			<label>Sobrenome:</label>
			<input name="sobrenome" value="${funcionario.sobrenome}"> <br>
			
			<label>Telefone:</label>
			<input name="telefone" value="${funcionario.telefone}"> <br>
			
			<label>E-mail:</label>
			<input name="email" value="${funcionario.email}"> <br>
			
			<label>Departamento:</label>
			<input name="departamento" value="${funcionario.nomeDepartamento}"> <br>
			
			<label>Empresa:</label>
			<input name="empresa" value="${empresa.nomeEmpresa}"> <br>
			
			<label>Endereço - Rua:</label>
			<input name="rua" value="${endereco.rua}"> <br>		
			
			<label>Bairro:</label>
			<input name="bairro" value="${endereco.bairro}"> <br>
			
			<label>Cidade:</label>
			<input name="cidade" value="${endereco.cidade}"> <br>			
			
			<input type="submit" value="Enviar" id="button" />
		</form>
	</div>
	
	<br/><br/><br/>
	
	<div align="center">
		<a href="${pageContext.request.contextPath}/ListarFuncionarioController">Listar Funcionarios</a>
		
		<a href="${pageContext.request.contextPath}/pages/index.jsp">Página Inicial</a>
	</div>
		
</body>
</html>