<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% User user=(User) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
  <h1>どこつぶログイン</h1>
  <% if(user!=null){ %>
  <p>ログインに成功しました</p>
  <p>ようこそ[<%=user.getName()%>]さん</p>
  <a href="/docoTsubu/Main">つぶやき投稿・閲覧へ</a>
  <%}else{ %>
  <p>ログインに失敗しました</p>
  <a href="/docoTsubu/index.jsp">TOPへ</a>
  <% } %>

</body>
</html>
