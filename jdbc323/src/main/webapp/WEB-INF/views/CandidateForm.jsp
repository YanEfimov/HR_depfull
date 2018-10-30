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

<h1 align="center">Add Candidate</h1>
        <form:form action="SaveCandidate" method="post" modelAttribute="candidate">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name"/></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><form:input path="surname"/></td>
                <td><form:errors path="surname"/></td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td><form:input type="date" path="birthday"/></td>

                <td><form:errors path="birthday"/></td>
            </tr>
            <tr>
                <td>Salary:</td>
                <td><form:input path="salary" /></td>
                <td><form:errors path="salary"/></td>
            </tr>
            <tr>
            	<td>CandidateState:</td>
            	<td><form:select path="candidateState" items="${candidatestate}"></form:select>
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