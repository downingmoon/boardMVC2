<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<h1>${title }</h1>
	<nav>
    <ul>
      <li><a href="jsp/mainimage.jsp">Home</a></li>
      <li class="dropdown">
        <a href="#" class="dropbtn">Board   </a>
        <div class="dropcontent">
          <a href="boardList.bo?btype=0">공지 게시판</a>
          <a href="boardList.bo?btype=1">자유 게시판</a>
          <a href="boardList.bo?btype=2">유머 게시판</a>
          <a href="boardList.bo?btype=3">btype=3</a>
        </div>
      </li>
    </ul>
  </nav>
</div>