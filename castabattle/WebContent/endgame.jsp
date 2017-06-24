<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.castaware.castabattle.domain.Board"%>
<%@page import="com.castaware.castabattle.domain.CellType"%>

<html>
<head>
<meta charset="utf-8">
<title>:::The Naval Battle:::End Game</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/normalize.css">
<link href="https://fonts.googleapis.com/css?family=Orbitron:400,900"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<div class="container">
		<header>
			<h1>THE BATTLE NAVAL</h1>
		</header>
		<div class="main">
			<br>
			SCORE
			<table style="color: white  ">
			
			<tr><td>Nome</td><td>Pontos</td></tr>
			<c:forEach items="${listaScore}" var="item">
				<tr>
					<td><c:out value="${item.jogador}" /></td><td><c:out value="${item.pontos}" /></td>
				</tr>
			</c:forEach>
			</table>
		    		

			<h1 class="end-game">End Game</h1>
			<a class="btn-principal" href="${pageContext.request.contextPath}/spring/game/start?nome=${nome}">start
				game</a>
		</div>
		<footer>
			<p class="text-footer">Programação Servidores Web</p>
		</footer>
	</div>
</body>
</html>