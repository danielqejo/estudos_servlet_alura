<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
	<p>Você está logado como: ${usuarioLogado.email}</p>
</c:if>

<h1>Adicionar uma nova Empresa</h1>
<form action="novaEmpresa" method="POST">
	Nome: <input type="text" name="nome" />
	<input type="submit" value="Enviar" />
</form>

<hr >
<h1>Efetuar Login!</h1>
<form action="login" method="POST">
	Email: <input type="email" name="email" />
	Senha: <input type="password" name="senha" />
	<input type="submit" value="Enviar" />
</form>

<hr>

<h1>Buscar Empresas</h1>
<form action="busca" method="GET">
	<input type="text" name="filtro">
	<input type="submit" value="Buscar">
</form>

<hr>

<form action="logout" method="POST">
	<input type="submit" value="Deslogar">
</form>
</body>
</html>