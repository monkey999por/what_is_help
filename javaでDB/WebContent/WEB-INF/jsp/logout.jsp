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
<% if( user==null ){ %>
  <p>ログアウトしました</p>
  <a href="http://localhost:8080/docoTsubu/index.jsp">TOPへ</a>
<% } else {%>
  <p>問題が発生しました。</p>
  <a href="https://www.youtube.com/watch?v=hHW1oY26kxQ">エラーレポート</a>
<% }%>
</body>
</html>
