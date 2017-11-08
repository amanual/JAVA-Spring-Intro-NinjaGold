<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type = "text/css" href = "css/style.css">
<title>Ninja Gold Game</title>
</head>
<body>
	<h2>Your Gold: <span><c:out value= "${ gold }" /></span></h2><a href ="/reset"> Reset </a>
	<div>
		<div class = "golds">
			<h2>Farm</h2>
			<p>(earns 10 - 20 gold)</p>
			<form method ="POST" action = "/golds">
			
				<button name = "farm" value = "farmValue">Find Gold!</button>
			</form>
		</div>
		<div class = "golds">
			<h2>Cave</h2>
			<p>(earns 5 - 10 gold)</p>
			<form method ="POST" action = "/golds">
				<button name = "cave" value = "caveValue">Find Gold!</button>
			</form>
		</div>
		<div class = "golds">
			<h2>House</h2>
			<p>(earns 2 - 5 gold)</p>
			<form method ="POST" action = "/golds">
				<button name = "house" value = "houseValue">Find Gold!</button>
			</form>
		</div>
		<div class = "golds">
			<h2>Casino!</h2>
			<p>(earns/takes 0 - 50 gold)</p>
			<form method ="POST" action = "/golds">
				<button name = "casino" value = "casinoValue">Find Gold!</button>
			</form>
		</div>
	</div>
	<div>
		<h2>Activities: </h2>
		<div class = "listMessage">
			<c:forEach items = "${ message }" var = "i">
			<p>${ i }</p>
			</c:forEach>
		</div>
	</div>

</body>
</html>