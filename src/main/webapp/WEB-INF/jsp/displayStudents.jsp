<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach var="student" items="${list}">
			<tr>
				<td>${student.name}</td>
				<td>${student.age}</td>
				<td>${student.className}</td>
				<td>${student.id}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" onclick='location.href="<%=path%>/exportExcelFile.html"' value="导出Excel表格"/>
</body>
</html>