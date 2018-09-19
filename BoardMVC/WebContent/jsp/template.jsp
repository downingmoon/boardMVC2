<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/${content }.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/boardList.css">
</head>
<body>
	<jsp:include page="top.jsp" />
	<jsp:include page="${content}.jsp" />
	<jsp:include page="bottom.jsp" />
</body>
</html>