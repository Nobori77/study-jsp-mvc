<%@page import="com.app.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 조회</title>
</head>
<body>

<%
    ProductVO product = (ProductVO)request.getAttribute("product");
%>

<table border="1">
    <tr>
        <th>상품번호</th>
        <th>상품명</th>
        <th>상품가격</th>
        <th>상품재고</th>
    </tr>
<%
    if(product != null){
%>
    <tr>
        <td><%=product.getId() %></td>
        <td><%=product.getProductName() %></td>
        <td><%=product.getProductPrice() %></td>
        <td><%=product.getProductStock() %></td>
    </tr>
<%
    }
%>
</table>
	<a href="/mvc/update.product?id=<%=product.getId() %>"> 수정하기</a>
	<a href="/mvc/delete-ok.product?id=<%=product.getId() %>"> 삭제하기</a>

</body>
</html>