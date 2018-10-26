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

<h1 align="center">Add User</h1>

    <div class="user_form">
        <form:form action="SaveUser" method="post" modelAttribute="user">
        <table>
        	<form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name"/></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><form:input path="surname" /></td>
                <td><form:errors path="surname"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" /></td>
                <td><form:errors path="password"/></td>
            </tr>
            <tr>
            	<td>Role:</td>
            	<td><form:select path="role" items="${map}"></form:select>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</div>
<footer> by Team-3</footer>
</body>

</html>