  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.Mutter" %>
<%@ page import="java.util.*" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<%-- <% User user=(User) session.getAttribute("loginUser");  %> --%>
 <%-- <% List <Mutter> mutterList=( List <Mutter>) application.getAttribute("mutterList"); %> --%>
 <%-- <% String error=(String) request.getAttribute("error");  %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
	<h1>どこつぶメイン</h1>
  <p><c:out value="${loginUser.name }" />さん、ログイン中	<a href="/docoTsubu/Logout">ログアウト</a></p>
  <a href="/docoTsubu/Main">更新</a>


  <form class="form" action="/docoTsubu/Main" method="post">
   <label for="text"">むったー：</label>
    <input type="text" name="text">
   <!--<br>
    <label for="filePath">ファイルパス：</label>
    <input type="text" name="filePath" size="50">
    <br>-->
     <input type="submit" value="つぶやく">
  </form>
  <br>
  	<c:choose>
  		<c:when test="${not empty error}">
  			${error}
  		</c:when>
  	</c:choose>

	 <c:forEach var="mutter" items="${mutterList}"  >
		${mutter.userName }:
		${mutter.text }
		<br>
	</c:forEach>





</body>
</html>
