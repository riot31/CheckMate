<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/WEB-INF/tags/functions.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game List</title>
    <link rel="stylesheet" href="/resources/css/normalize.css"/>
    <link rel="stylesheet" href="/resources/css/table.css"/>
    <link rel="stylesheet" href="/resources/css/component.css"/>
</head>
<body>

<div class="container">
    <div class="component">
        <h2>${f:getMessage("page.game.select")}</h2>
        <p>
            ${f:getMessage("page.game.info")}
        </p>
        <table>
            <thead>
            <tr>
                <th>${f:getMessage("page.game.member")}</th>
                <th>${f:getMessage("page.game.member")}</th>
                <th>${f:getMessage("page.game.headline")}</th>
                <th>${f:getMessage("page.game.date")}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${gameList}" var="game">
                <c:if test="${empty game.member2 and game.member1 != username}">
                    <tr data-href="/game/take?uuid=${game.uuid}">
                        <td class="user-name">${game.member1}</td>
                        <td class="user-email">${game.member2}</td>
                        <td class="user-phone">${game.headline}</td>
                        <td class="user-mobile">${game.time}</td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
<script src="/resources/js/jquery.stickyheader.js"></script>
<script>
    $('tr[data-href]').on("click", function() {
        document.location = $(this).data('href');
    });
</script>
</body>
</html>
