<%@page import="com.app.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<%
		PostVO post = (PostVO)request.getAttribute("post");
	%>
	<form action="/mvc/postupdate-ok.post" method="post">
		<input name="id" type="hidden" value="<%=post.getId() %>">
		<div>
			<span>제목</span>
			<input name="postTitle" value="<%=post.getPostTitle() %>"/>		
		</div>
		<div>
			<span>상품 가격</span>
			<input name="postContent" value="<%=post.getPostContent() %>"/>		
		</div>
		<button>게시글 수정</button>
	</form>
</body>
</html>