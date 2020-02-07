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

<h1>회원 정보 수정</h1>
<form action="mupdate.do" method="post">

본인 ID:<input readonly name="id" value="${login.id}"><br>
비번 : <input required name="pw"><br>
수정할 정보:<br>
Name:<input required name="name" value="${dto.name}"><br>
생년월일:<input required name="birth" value="${dto.birth }"><br>
email:<input required name="email" value="${dto.email }" ><br>
	<input type="submit" value="수정">
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>