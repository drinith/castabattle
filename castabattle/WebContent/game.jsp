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
          <tr>
            <td class="label-table">1</td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="water"></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
          </tr>
          <tr>
            <td class="label-table">2</td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="hidden"><a href=""></a></td>
            <td class="water"></td>
            <td class="fire"></td>
            <td class="water"></td>
          </tr>
          <tr>
            <td class="label-table">3</td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
          </tr>
          <tr>
            <td class="label-table">4</td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="fire"></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
          </tr>
          <tr>
            <td class="label-table">5</td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="fire"></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
          </tr>
          <tr>
            <td class="label-table">6</td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="fire"></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
          </tr>
          <tr>
            <td class="label-table">7</td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
          </tr>
          <tr>
            <td class="label-table">8</td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
          </tr>
          <tr>
            <td class="label-table">9</td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
          </tr>
          <tr>
            <td class="label-table">10</td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="fire"></td>
            <td class="fire"></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
            <td class="water"><a href=""></a></td>
          </tr>
        </table>
      </div>
      <footer>
        <p class="text-footer">Programação Servidores Web</p>
      </footer>
    </div>
  </body>
</html>
