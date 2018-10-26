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
<h1 align="center">Create User</h1>
        <form:form action="SaveUser" method="post" modelAttribute="user">
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><form:input path="surname" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
            	<td>Role:</td>
            	<td><form:select path="role" items="${map}"></form:select>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
</div>
<footer> by Team-3</footer>
</body>

</html>