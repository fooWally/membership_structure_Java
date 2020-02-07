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
<jsp:include page="m_login.jsp"/> 

	<h1>게시판</h1> <a href="binsertui.do">글쓰기</a>
	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>root</th>
				<th>step</th>
				<th>indent</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td>
					<c:forEach begin="1" end="${dto.repIndent}"> <!-- 원래 글은 들여쓰기가 안되게 1부터 시작 -->
						&nbsp;&nbsp;
					</c:forEach>
					<a href="bread.do?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.author}</td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>
					<td>${dto.repRoot}</td>
					<td>${dto.repStep}</td>
					<td>${dto.repIndent}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<%-- 페이징 --%>
	<%-- html주석(<!-- -->) 쓰지 말고 이 주석 쓰기!!!!!!!!! --%>
	<%-- 파람액션태그가 있을 때는  [[[ <jsp:include page=""></jsp:include> 없을때는 <jsp:include page=""/> ]]]  --%> 
	<jsp:include page="b_page.jsp"/>
	
</body>
<jsp:include page="footer.jsp"/>
</html>