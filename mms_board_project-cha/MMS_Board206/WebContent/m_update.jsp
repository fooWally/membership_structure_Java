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

<h1>ȸ�� ���� ����</h1>
<form action="mupdate.do" method="post">

���� ID:<input readonly name="id" value="${login.id}"><br>
��� : <input required name="pw"><br>
������ ����:<br>
Name:<input required name="name" value="${dto.name}"><br>
�������:<input required name="birth" value="${dto.birth }"><br>
email:<input required name="email" value="${dto.email }" ><br>
	<input type="submit" value="����">
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>