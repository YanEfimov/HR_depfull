<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<h1 align="center">Add Vacancy</h1>

        <form:form action="SaveVacancy" method="post" modelAttribute="vacancy">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>Position:</td>
                <td><form:input path="position" /></td>
                <td><form:errors path="position"/></td>
            </tr>
            <tr>
                <td>SalaryFrom(usd):</td>
                <td><form:input path="salaryfrom"/></td>
                <td><form:errors path="salaryfrom"/></td>
            </tr>
            <tr>
                <td>SalaryTo(usd):</td>
                <td><form:input path="salaryto"/></td>
                <td><form:errors path="salaryto"/></td>

            </tr>
            <tr>
                <td>Experience(years):</td>
                <td><form:input path="experienceYearRequire" /></td>
                <td><form:errors path="experienceYearRequire"/></td>
            </tr>
            <tr>
            	<td>Developer:</td>
            	<td><form:select path="idDeveloper" items="${developers}"></form:select>
            </tr>
            <tr>
            	<td>Skills:</td>
            	<td><form:select path="skills" items="${skills}"></form:select></td>
            	<td><form:errors path="skills"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
</div>
    <footer> by Team-3</footer>
</body>

</html>