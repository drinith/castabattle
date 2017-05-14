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
    <title>:::Batalha Naval:::</title>
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
        <h1 class="fim-jogo">Fim de Jogo</h1>
      </div>
      <footer>
        <p class="text-footer">Programação Servidores Web</p>
      </footer>
    </div>
  </body>
</html>