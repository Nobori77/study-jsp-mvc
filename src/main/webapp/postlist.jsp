<%@page import="com.app.vo.PostVO"%>
<%@page import="com.app.dao.PostDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
    <%
        PostDAO postDAO = new PostDAO();
        List<PostVO> posts = postDAO.selectAll();
    %>
    <table border="1">
        <tr>
            <th>게시판번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성시간</th>
        </tr>
        <%
            for(PostVO post : posts) {
        %>
		<tr>
         <td><%= post.getId() %></td>
         <td>
             <a href="/mvc/postread.post?id=<%= post.getId() %>">
            <%= post.getPostTitle() %>
             </a> 
            </td>
         <td><%= post.getPostContent() %></td>
         <td><%= post.getPostCreateAt() %></td>
      </tr>
        <%
            }
        %>
    </table>
</body>
</html>