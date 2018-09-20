<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="kr.itedu.boardmvc.*"%>
<%@ page errorPage="errorPage.jsp"%>
<%
	ArrayList<BoardVO> result = (ArrayList<BoardVO>)request.getAttribute("data");
%>
<%
	String title = (String)request.getAttribute("title");
%>
<%
	// result.clear();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/boardList.css">
</head>
<body>
	
	<div class="container">
	<!--<jsp:include page="top.jsp" /> -->
		<%
			if (result.isEmpty()) {
		%>
		<h2>내용이 없습니다.</h2>
		<%
			} else {
		%>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th class="th">제목</th>
					<th>등록일자</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (BoardVO vo : result) {
				%>
				<tr>
					<td><%=vo.getBid()%></td>
					<td><a href="boardDetail.bo?btype=${btype}&bid=<%=vo.getBid()%>"> <%=vo.getBtitle()%>
					</a></td>
					<td><%=vo.getBregdate()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
		<!-- <form action="boardInsert.bo?" method="get">
			<input type="submit" value="글쓰기">
			<input type="hidden" value="${btype}" name="btype">
		</form> -->
		<button onclick="location.href='boardInsert.bo?btype=${btype}'">글쓰기2</button>
		<!-- <jsp:include page="bottom.jsp"></jsp:include> -->
	</div>

</body>
</html>