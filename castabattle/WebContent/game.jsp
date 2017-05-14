<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" 
          contentType="text/html; charset=ISO-8859-1" 
          pageEncoding="ISO-8859-1"%>
                 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.castaware.castabattle.domain.Board" %>
<%@page import="com.castaware.castabattle.domain.CellType" %>

<html>
  <head>
    <meta charset="utf-8">
    <title>:::Batalha Naval::: Jogo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <link href="https://fonts.googleapis.com/css?family=Orbitron:400,900" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
  </head>
  <body>
    <div class="container">
      <header>
        <h1>BATALHA NAVAL</h1>
      </header>
      
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
          		
          		  <c:set var="result" value='${board.readInGame(k,i)}'/> 
         			          		
          		<c:choose>
			      	<c:when test="${result=='WATER'}">
			      	  <td class="water"></td>
			      	</c:when>
			      	<c:when test="${result=='FIRE'}">
			      	  <td class="fire"></td>
			      	</c:when>
			      	<c:otherwise>
			      		<td class="hidden">
					      	<a href="${pageContext.request.contextPath}/spring/game/fire?line=${i}&column=${k}">
						      	<img alt="atirar" src="${pageContext.request.contextPath}/images/hidden.png">
					      	</a>
				      	</td>
			      	</c:otherwise>
		      	</c:choose> 
          	</c:forEach>
          </tr>
          </c:forEach>
         
        </table>
      </div>
      <footer>
        <p class="text-footer">Programação Servidores Web</p>
      </footer>
    </div>
  </body>
</html>
