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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>:::The Naval Battle:::</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <link href="https://fonts.googleapis.com/css?family=Orbitron:400,900" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
  </head>
  <body>
    <div class="container">
      <header>
        <h1>THE NAVAL BATTLE</h1>
      </header>
      <div class="main">
      	<form class="form-container" action="${pageContext.request.contextPath}/spring/game/start" method="get">
      		<div class="input-container">
	      		<label for="nome">name:</label>
	      		<input type="text" name="nome" placeholder="Player Name"/>
      		</div>
      		<button type="submit" class="btn-principal" >start game</button>
      	</form>
      </div>
      <footer>
        <p class="text-footer">Programa��o Servidores Web</p>
      </footer>
    </div>
  </body>
</html>