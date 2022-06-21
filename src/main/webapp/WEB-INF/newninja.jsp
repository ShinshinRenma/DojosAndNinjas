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
    <h1>Add a Ninja</h1>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>    
    <form:form action="/ninjas" method="post" modelAttribute="ninja">
    <p>
        <form:label path="dojo">Dojo Name</form:label>
        <form:select  path="dojo">
        <form:option value="NONE"> --SELECT--</form:option>
        <c:forEach var="dojo" items="${dojos}">
            <form:option value="${dojo}"><c:out value="${dojo.name}"></c:out></form:option>
        </c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input type="lastName" path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>     
        <form:input type="number" path="age"/>
    </p>    
    <input type="submit" value="Create"/>
    </form:form>    
</body>
</html>
