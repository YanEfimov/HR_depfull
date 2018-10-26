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
<h1 align="center">Vacancy Base</h1>

<p align="center"><a href="VacancyCreate" class="create-button">Create vacancy</a></p>

<div class="filter-sort">
	Filter by:
	<a href="ViewVacancyForm" class="filter-sort-item">Find all</a>
    Sort by:
    <a href="SortSalaryFrom" class="filter-sort-item">SalaryFrom</a>
	<a href="SortSalaryTo" class="filter-sort-item">SalaryTo</a>
	<a href="SortExperience" class="filter-sort-item">Experience</a>
</div>

    <!--  <p>Filter by | who create
    	<form action="FilterByCreate" method="GET">
    		<td><select path="dev" items="${developers}"></select>
    		<td><input type="submit" value="OK"></td>
    	</form>-->
</span>
<table border="1">
	<tr>
		<th>Position</th>
		<th>Salary from</th>
		<th>Salary to</th>
		<th>Experience</th>
		<th>Who create</th>
		<th>Skills</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="vacancy" items="${list}">
		<tr>
			<td><c:out value="${vacancy.position}"/></td>
			<td><c:out value="${vacancy.salaryfrom}"/></td>
			<td><c:out value="${vacancy.salaryto}"/></td>
			<td><c:out value="${vacancy.experienceYearRequire}"/></td>
			<td><c:out value="${vacancy.developername}"/></td>
			<td>
				<c:forEach var="skill" items="${vacancy.skills}">
					<c:out value="${skill}"/>|
				</c:forEach>
			</td>
			<td><a href="VacancyEdit?id=${vacancy.id}">Edit</a></td>
			<td><a href="VacancyDelete?id=${vacancy.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</div>
<footer> by Team-3</footer>
</body>

</html>