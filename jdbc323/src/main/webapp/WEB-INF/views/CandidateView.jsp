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
	<h1 align="center">Candidates Base</h1>

<p align="center"><a href="CandidateCreate" class="create-button">Create Candidate</a></p>
<div class="filter-sort">
Filter by:
<a href="ViewCandidateForm" class="filter-sort-item">Find all</a>
<a href="CandidateFilter?type=active" class="filter-sort-item">active</a>
<a href="CandidateFilter?type=passive" class="filter-sort-item">passive</a>
Sort by: <a href="CandidateSortSalary" class="filter-sort-item">salary</a>
<a href="CandidateSortName" class="filter-sort-item">name</a>
</div>

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Birthday</th>
			<th>Salary</th>
			<th>CandidateState</th>
			<th>Skills</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="candidate" items="${list}">
			<tr>
				<td><c:out value="${candidate.name}"></c:out></td>
				<td><c:out value="${candidate.surname}"/></td>
				<td><c:out value="${candidate.birthday}"/></td>
				<td><c:out value="${candidate.salary}"/></td>
				<td><c:out value="${candidate.candidateState}"/></td>
				<td>
					<c:forEach var="skill" items="${candidate.skills}">
						<c:out value="${skill}"/>|
					</c:forEach>
				</td>
				<td><a href="CandidateEdit?id=${candidate.id}">Edit</a></td>
			    <td><a href="CandidateDelete?id=${candidate.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</div>
<footer> by Team-3</footer>
</body>

</html>