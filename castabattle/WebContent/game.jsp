<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.castaware.castabattle.domain.Board"%>
<%@page import="com.castaware.castabattle.domain.CellType"%>

<html>
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
	<script src="http://code.jquery.com/jquery-latest.min.js"
        type="text/javascript"></script>
	<script type="text/javascript">
			function loadDoc(linha, coluna, nome) {
// 				var xhttp = new XMLHttpRequest();
// 				xhttp.onreadystatechange = function() {
// 					if (this.status == 200) {
// 						document.getElementById("main").innerHTML = this.responseText;
// 					}
// 				};
// 				xhttp
// 						.open("GET",
// 								"${pageContext.request.contextPath}/spring/game/fire?line="
// 										+ linha + "&column=" + coluna
// 										+ "&nome=" + nome, "true");
// 				;
// 				xhttp.send();

			
					//var menuId = $( "ul.nav" ).first().attr( "id" );
					
					$.ajax({
					  url: "${pageContext.request.contextPath}/spring/game/fire",
					  method: "GET",
					  data: {line:linha,column:coluna,nome:nome},
					  dataType: "html",
					  success: function(result){
						  var headline = $(result).find('#main'); 
					      $("#main").html(headline); 

					  }

					  }); 
				
				
				
				
			}
		</script>	
	
	<div class="container">
		<header>
			<h1>THE NAVAL BATTLE 2</h1>
		</header>

		
		<div class="main" id="main">
			<div class="player-detail">
				<p>
					Player: <span>${param.nome}</span>
				</p>
				<c:if test="${target != null}">
					<c:choose>
						<c:when test="${target == 'WATER'}">
							<p class="target-water">You shot in: ${target}</p>
						</c:when>
						<c:otherwise>
							<p class="target-right">You shot in: ${target}</p>
						</c:otherwise>
					</c:choose>
				</c:if>
				<p>
					Score: <span>${pontos}</span>
				</p>
			</div>
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
									<td class="hidden">
										<%-- 				      			<button  onclick='loadDoc("${i}","${k}","${param.nome}")' >  --%>
										<%-- 				      				<img alt="shot here?" src="${pageContext.request.contextPath}/images/hidden.png"> --%>
										<!-- 				      			</button> --> <a href="#"
										onclick='loadDoc("${i}","${k}","${param.nome}");'> <img
											alt="shot here?"
											src="${pageContext.request.contextPath}/images/hidden.png">
									</a>
									</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>

					</tr>
				</c:forEach>
			</table>
			<div class="main-bottom">
				<a class="btn-small"
					href="${pageContext.request.contextPath}/spring/game/reset?nome=${param.nome}">reset
					game</a>
			</div>
		</div><!-- FIM DIV MAIN -->
		<footer>
			<p class="text-footer">Programação Servidores Web</p>
		</footer>
	</div><!-- FIM DIV CONTAINER -->
</body>
</html>
