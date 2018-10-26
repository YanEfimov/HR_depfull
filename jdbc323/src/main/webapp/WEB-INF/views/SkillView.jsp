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
<header><a href="back">HR Application</a></header>
<div class="main-block">
    <h1 align="center">Show Skills Base</h1>
    <p align="center"><a href="SkillCreate" class="create-button">Create skill</a></p>

    <div class="filter-sort">
    	Filter by <a href="ViewSkillForm" class="filter-sort-item">Find all</a>
        Sort by: <a href="SkillSort" class="filter-sort-item">name</a>
    </div>

	<table border="1">
		<tr>
			<th>Skill</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="skill" items="${list}">
			<tr>
				<td><c:out value="${skill.name}"/></td>
				<td><a href="SkillDelete?name=${skill.name}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
        <footer> by Team-3</footer>
</body>
</html>