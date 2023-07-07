<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scoreboard</title>
</head>
<body>
    <c:forEach items="${requestScope.scores}" varStatus="st" var="score">
        <h6>${st.index}. name = ${score.name} score = ${score.scope}</h6>
        <br>
        
    </c:forEach>
</body>
</html>
