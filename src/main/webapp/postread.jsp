<%@page import="com.app.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 조회</title>
</head>
<body>

<%
    PostVO post = (PostVO)request.getAttribute("post");
%>

<table border="1">
    <tr>
        <th>게시판번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성시간</th>
    </tr>
<%
    if(post != null){
%>
    <tr>
        <td><%=post.getId() %></td>
        <td><%=post.getPostTitle() %></td>
        <td><%=post.getPostContent() %></td>
        <td><%=post.getPostCreateAt() %></td>
    </tr>
<%
    }
%>
</table>
	<a href="/mvc/postupdate.post?id=<%=post.getId() %>"> 수정하기</a>
	<a href="/mvc/postdelete-ok.post?id=<%=post.getId() %>"> 삭제하기</a>

</body>
</html>