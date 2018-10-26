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

	<h1 align="center">Show Interviews</h1>
	<p align="center"><a href="InterviewCreate" class="create-button">Create interview</a></p>


	<div class="filter-sort">
		Filter by: <a href="InterviewView" class="filter-sort-item">Find all</a>
		Sort by: <a href="SortPlanDate" class="filter-sort-item">Plan date</a>
				<a href="SortFactDate" class="filter-sort-item">Fact date</a>
	</div>


	<table border="1">
		<tr>
			<th>Name</th>
			<th>FactDate</th>
			<th>PlanDate</th>
			<th>Vacacny</th>
			<th>Candidate</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="interview" items="${list}">
			<tr>
				<td><c:out value="${interview.name}"/></td>
				<td><c:out value="${interview.factDate}"/></td>
				<td><c:out value="${interview.planDate}"/></td>
				<td><c:out value="${interview.vacancyname}"/></td>
				<td><c:out value="${interview.candidatename}"/></td>
			    <td><a href="InterviewEdit?id=${interview.id}">Edit</a></td>
			    <td><a href="InterviewDelete?id=${interview.id}">Delete</a></td>
		</c:forEach>
	</table>
</div>
<footer> by Team-3</footer>
</body>
</html>