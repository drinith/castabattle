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
<meta name="viewport" content="width=device-width, initial-scale=1">
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
		<div class="main endgame" id="main">
			<h1 class="end-game">End Game</h1>
			<form class="form-container" action="${pageContext.request.contextPath}/spring/game/start" method="get">
	      		<div class="input-container">
		      		<label for="nome">Player:</label>
		      		<input type="text" name="nome" placeholder="Player Name" value="${nome}"/>
	      		</div>
	      		<button type="submit" class="btn-principal" >start again</button>
      		</form>
			<div class="score-container">
				<h1>Score:</h1>
				<table>
					<c:forEach items="${listaScore}" var="item">
						<tr>
							<td class="item-name"><c:out value="${item.jogador}" /></td>
							<td class="item-score"><c:out value="${item.pontos}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<footer>
			<p class="text-footer">Programação Servidores Web</p>
		</footer>
	</div>
</body>
</html>