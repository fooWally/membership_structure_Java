<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="header.jsp"/>

<h1>회원 등록</h1>

<form action="insert.do" method="post">

	<label for="id">ID: </label>
	<input name="id" id="id" required>
	<button>중복체크</button>
		<p></p>
	<label for="name">NAME: </label>
	<input name="name" id="name" required>	
	<br>
	<label for="age">AGE: </label>
	<input name="age" id="age" type="number">
	<br>
	<label for="pw">PW: </label>
	<input name="pw" id="pw" type="password">
	<br>
	<input type="submit" value="등록">
	
</form>

<script type="text/javascript">

	$(document).ready(function() {
		
		$("button").click(function() { 
			var id = $("input[name='id']").val(); 
			
			$.ajax({
	            type:'get',
	            url   : 'checkid.do',
	            data: {
	               id : id
	            },
	            dataType:'text',
	            success: function(result){
	               $("p").text(result);
	            }
			});
		});
	});
	
</script>

<jsp:include page="footer.jsp"/>

</body>
</html>