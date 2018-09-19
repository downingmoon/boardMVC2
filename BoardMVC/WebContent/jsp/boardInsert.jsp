<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardInsert.bo" method="post">
	제목 : <input type="text" name="btitle"><br>
	내용 : <textarea name="bcontent" rows="8" cols="60"></textarea><br>
	<input type="submit" value="작성">
</form>

</body>
</html>