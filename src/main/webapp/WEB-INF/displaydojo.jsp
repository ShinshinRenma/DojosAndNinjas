<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Save Travels</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
    <h1><c:out value="${dojo.name}"></c:out> Location Ninjas</h1>
    <table class="table">
        <tbody>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
            <c:forEach var="ninja" items="${dojo.ninjas}">
            <tr>
                <td><c:out value="${ninja.firstName}"></c:out></a></td>
                <td><c:out value="${ninja.lastName}"></c:out></td>
                <td><c:out value="${ninja.age}"></c:out></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>