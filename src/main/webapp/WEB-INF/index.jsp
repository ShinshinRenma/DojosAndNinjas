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
    <h1>Dojos and Ninjas</h1>
        <a href="/dojos/new">Create a New Dojo</a>
        <a href="/ninjas/new">Create a New Ninja</a>
        <h2>Currently Existing Dojos</h2>
        <c:forEach var="dojo" items="${dojos}">
            <h6><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"></c:out></a></h6>
        </c:forEach>
</body>
</html>
