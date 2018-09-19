<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="kr.itedu.boardmvc.*"%>
<%@ page errorPage="errorPage.jsp" %>
<% BoardVO vo = (BoardVO)request.getAttribute("data"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardDetail</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/boardList.css">
</head>
<body>
<div class="container">
	
	<table>
		<thead>
			<tr>
				<th>내용</th>
				<th>작성일시</th>
			</tr>
			<tr>
				<td><%=vo.getBcontent() %><br></td>
				<td><%=vo.getBregdate() %></td>
			</tr>
		</thead>
	</table>
<a href="#" onclick="history.back()">메인으로 가기</a>
</div>
</body>
</html>