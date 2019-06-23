<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<% String loginError=(String) request.getAttribute("loginError");  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>

</head>
<body>
	<h1>どこつぶへようこそ</h1>

  <form class="form" action="/docoTsubu/Login" method="post">
    <label for="name">ユーザー名: </label>
    <input type="text" name="name" value="koyomi"><br>
    <label for="pass">パスワード: </label>
    <input type="password" name="pass"  value="1234"><br>
    <input type="submit" name="" value="ログイン"><br>
  </form>
<br>
  


  <script src="./script/test.js" charset="utf-8"></script>



</body>
</html>
