<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<style>
	<%@include file="../styles/home_style.css"%>
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%--<header><a href="<%="WEB-INF/views/home.jsp"%>">HR Application</a></header>--%>
<header><a href="back">HR Application</a></header>
<div class="main-block">

<h1 align="center">Users Base</h1>
<p align="center"><a href="UserCreate" class="create-button">Add user</a></p>

<div class="filter-sort">
Filter by:
<a href="ViewUserForm" class="filter-sort-item">Find all</a>
<a href="UserFilter?type=manager" class="filter-sort-item">manager</a>
<a href="UserFilter?type=developer" class="filter-sort-item">developer</a>
Sort by: <a href="UserSortName" class="filter-sort-item">name</a>
</div>

<table border="1">
	<tr>
		<th>Name</th>
		<th>Surname</th>
		<th>Email</th>
		<th>Password</th>
		<th>Role</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td><c:out value="${user.name}"></c:out></td>
			<td><c:out value="${user.surname}"/></td>
			<td><c:out value="${user.email}"/></td>
			<td><c:out value="${user.password}"/></td>
			<td><c:out value="${user.role}"></c:out></td>
			<td><a href="UserEdit?id=${user.id}">Edit</a></td>
			<td><a href="UserDelete?id=${user.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>

</div>
<footer> by Team-3</footer>
</body>

</html>