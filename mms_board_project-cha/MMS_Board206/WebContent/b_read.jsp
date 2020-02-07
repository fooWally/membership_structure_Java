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
<h1>�� �ڼ��� ����</h1>
num: ${dto.num}<br>
author: ${dto.author}<br>
writeday: ${dto.writeday}<br>
readcnt: ${dto.readcnt}<br>
title: ${dto.title}<br>
content<br>
<div>
	${dto.content}
</div>
<br>
<c:choose>
<c:when test="${login.id == dto.author}" >
	<a href="bupdateui.do?num=${dto.num}" >����</a>
	<a href="bdeleteui.do?num=${dto.num}" >����</a> 
	<a href="breplyui.do?num=${dto.num}">���</a>
	<a href="blist.do">���</a>
</c:when>
<c:otherwise>
	<a href="bread.do?num=${dto.num}" onclick="alert('�ۼ��ڰ� �ƴմϴ�')">����</a>
	<a href="bread.do?num=${dto.num}" onclick="alert('�ۼ��ڰ� �ƴմϴ�')">����</a> 
	<a href="breplyui.do?num=${dto.num}">���</a>
	<a href="blist.do">���</a>
</c:otherwise>
</c:choose>

</body>
</html>