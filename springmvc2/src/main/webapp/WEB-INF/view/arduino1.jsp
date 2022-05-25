<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> 
	<meta charset="UTF-8">
	<title>Hello</title>
	<link href='http://fonts.googleapis.com/css?family=Lato:100' rel='stylesheet' type='text/css'>
	<style>
		 body {
			background-color: hsl(0, 60%, 65%);
			transition: background-color 1s; 
		} 

		h1 {
			font-family: 'Lato', sans-serif;
			font-size: 120px;
			font-weight: 100;
			color: white;
			text-align: center;
			margin: 60px;
		}

		h1:before{
			content: attr(class) ":";
			font-size: 22px;
			position: relative;
			top: -69px;
			left: 0;
			text-transform: uppercase;
		}
</style>

</head>
<body id=b>
<h1 id=data class="data">${applicationScope.data}</h1> <!-- ServletContext를 이용한 방법 -->
<%-- <h1 id=data class="data">${data}</h1> --%>
<script>
   setInterval(function(){ location.href="/serial1" }, 3000); 
</script>
</body>
</html>