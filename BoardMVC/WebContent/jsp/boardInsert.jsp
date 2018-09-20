<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<%
	request.getParameter("btype");    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardInsert.bo?" method="get">
	제목 : <input type="text" name="btitle"><br>
	내용 : <textarea name="bcontent" rows="8" cols="60"></textarea><br>
	<input type="submit" value="작성">
	<input type="hidden" value="${btype}">
	<!-- <input type="hidden" value="${bid}"> -->
</form>
<!-- 
<form action="boardInsert.bo?" method="get">
			<input type="submit" value="글쓰기">
			<input type="hidden" value="${btype}" name="btype">
 -->
</body>
<!--
1번 답 : 순서대로 CVS / SVN / Git

2번 :

Calc.java - 메소드는 sum 메소드 하나, 잘못된 메소드임. 더한값이 아닌 곱한값이 나옴
index.jsp -  
작업할때 workspace 새로 만들어서 사용.
work_one(workspace폴더 하나 더 만듬) 이클립스 연결. 인코딩 설정 UTF8로 변경
후 위 두 파일 import, 깃허브 아이디에 로그인 해서 repositories 만들라고 함.
이클립스랑 연동(clone) Exam10 프로젝트와 새로만들 repositories에 연결.
exam10 프로젝트에 있는 모든파일 push
본인 GitHub URL 기재.

3번 :
junit5 라이브러리 추가
패키지 생성
CalcTest.java 이용, Calc.java 오류제거
assertequals 2-3개정도 사용
Calc, CalcTest 파일 push.

4번(외워야함)
build.xml 파일 도구를 활용하여 생성
build.xml을 활용하여 빌드수행
console탭 활용, 빌드정상적 수행 확인
build.xml push하기

5번 
work_two 폴더 생성, workspace로 설정
인코딩 설정
톰캣 설정
이클립스 git repositories에 ex10 repository 클론
클론한 ex10 활용하여 import project 수행하여 exam10 프로젝트 임포트

6번
ex10 프로젝트를  .war 파일로 배포, 톰캣설치폴더 > "webapps"폴더 아래에 위치
톰캣을 가동하여 문제없는지 확인 

 -->
</html>