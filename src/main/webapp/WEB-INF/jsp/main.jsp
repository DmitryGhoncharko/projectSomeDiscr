
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        .container {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            max-width: 100vw;
            max-height: 100vh;
        }

        .gif {
            display: block;
            width: 100%;
            height: 100%;
            object-fit: contain;
        }

        .links-container {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
            pointer-events: none;
        }

        .link {
            display: block;
            margin-bottom: 10px;
            color: white;
            text-decoration: none;
            pointer-events: auto;
        }
    </style>
</head>
<body>
<div class="container">
    <img class="gif" src="${pageContext.request.contextPath}/static/leaders.gif" alt="GIF">
    <div class="links-container">
        <a class="link" href="your-link-url1">Start game</a>
        <a class="link" href="/controller?command=scoreboard">Scoreboard</a>
    </div>
</div>
</body>
</html>