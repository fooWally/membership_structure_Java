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

	<h1>�Խ���</h1> <a href="binsertui.do">�۾���</a>
	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>��ȸ��</th>
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
					<c:forEach begin="1" end="${dto.repIndent}"> <!-- ���� ���� �鿩���Ⱑ �ȵǰ� 1���� ���� -->
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
	
	<%-- ����¡ --%>
	<%-- html�ּ�(<!-- -->) ���� ���� �� �ּ� ����!!!!!!!!! --%>
	<%-- �Ķ��׼��±װ� ���� ����  [[[ <jsp:include page=""></jsp:include> �������� <jsp:include page=""/> ]]]  --%> 
	<jsp:include page="b_page.jsp"/>
	
</body>
<jsp:include page="footer.jsp"/>
</html>