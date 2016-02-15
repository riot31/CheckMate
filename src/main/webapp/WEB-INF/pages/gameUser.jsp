<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h2>Выберите партию</h2>

        <p>Здесь вы граете с реальными людьми и бла бла бла .................................
            если хотите померяться силами с ботом то переходите по ссылке <a href="#">Boot вас всех порвёт!</a>
        </p>
        <table>
            <thead>
            <tr>
                <th>Соперник</th>
                <th>Соперник</th>
                <th>Заголовок</th>
                <th>Дата создания</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${gameList}" var="game">
                <tr data-href="/game/go?uuid=${game.uuid}">
                    <td class="user-name">${game.member1}</td>
                    <td class="user-email">${game.member2}</td>
                    <td class="user-phone">${game.headline}</td>
                    <td class="user-mobile">${game.time}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
<script src="/resources/js/jquery.stickyheader.js"></script>
<script>
    $('tr[data-href]').on("click", function () {
        document.location = $(this).data('href');
    });
</script>
</body>
</html>
