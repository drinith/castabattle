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
<title>:::The Naval Battle:::Game</title>
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
			<h1>THE NAVAL BATTLE</h1>
		</header>

		<c:choose>
			<c:when test="${empty param.nome}">
        Jogador: ${param.name}
    </c:when>
			<c:otherwise>
        Jogador: ${param.nome}
        <c:set var="name" scope="session" value="${param.nome}" />
       
				
			</c:otherwise>
		</c:choose>

${sessionScope[name]}



		<div class="main">
			<table>
				<tr>
					<th></th>
					<td class="label-table">A</td>
					<td class="label-table">B</td>
					<td class="label-table">C</td>
					<td class="label-table">D</td>
					<td class="label-table">E</td>
					<td class="label-table">F</td>
					<td class="label-table">G</td>
					<td class="label-table">H</td>
					<td class="label-table">I</td>
					<td class="label-table">J</td>
				</tr>

				<c:forEach var="i" begin="1" end="10">
					<tr>
						<td class="label-table">${i}</td>
						<c:forEach var="k" begin="1" end="10">

							<c:set var="result" value='${board.readInGame(k,i)}' />

							<c:choose>
								<c:when test="${result=='WATER'}">
									<td class="water"><img alt="water"
										src="${pageContext.request.contextPath}/images/water.png">
									</td>
								</c:when>
								<c:when test="${result=='FIRE'}">
									<td class="fire"><img alt="fire"
										src="${pageContext.request.contextPath}/images/fire.png">
									</td>
								</c:when>
								<c:otherwise>
									<td class="hidden"><a
										href="${pageContext.request.contextPath}/spring/game/fire?line=${i}&column=${k}&nome=${param.nome}">
											<img alt="shot here?"
											src="${pageContext.request.contextPath}/images/hidden.png">
									</a></td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
			<div class="main-bottom">
				<c:if test="${target != null}">
					<p class="target">You shot in: ${target}</p>
				</c:if>
				<a class="btn-principal btn-small"
					href="${pageContext.request.contextPath}/spring/game/reset">reset</a>
			</div>
		</div>
		<footer>
			<p class="text-footer">Programação Servidores Web</p>
		</footer>
	</div>
</body>
</html>
