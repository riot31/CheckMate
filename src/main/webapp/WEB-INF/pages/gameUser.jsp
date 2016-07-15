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

        <div class="tabGroup">
            <input type="radio" name="tabGroup1" id="rad1" class="tab1" checked="checked"/>
            <label for="rad1">Текущие</label>

            <input type="radio" name="tabGroup1" id="rad2" class="tab2"/>
            <label for="rad2">Ожидающие</label>

            <input type="radio" name="tabGroup1" id="rad3" class="tab3"/>
            <label for="rad3">Завершённые</label>

            <br/>

            <div class="tab1">
                <table>
                    <thead>
                    <tr>
                        <th>${f:getMessage("page.game.member")}</th>
                        <th>${f:getMessage("page.game.member")}</th>
                        <th>${f:getMessage("page.game.headline")}</th>
                        <th>${f:getMessage("page.game.strokes")}</th>
                        <th>${f:getMessage("page.game.date")}</th>
                        <th>${f:getMessage("page.game.status")}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${gameList}" var="game">
                        <c:if test='${game.status.equals("начата")}'>
                            <tr data-href="/game/go?uuid=${game.uuid}">
                                <td class="user-name">${game.member1}</td>
                                <td class="user-email">${game.member2}</td>
                                <td class="user-phone">${game.headline}</td>
                                <td class="user-phone">${game.getStrokesCount()}</td>
                                <td class="user-mobile">${game.time}</td>
                                <td class="user-mobile">${game.status}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab2">
                <table>
                    <thead>
                    <tr>
                        <th>${f:getMessage("page.game.member")}</th>
                        <th>${f:getMessage("page.game.member")}</th>
                        <th>${f:getMessage("page.game.headline")}</th>
                        <th>${f:getMessage("page.game.strokes")}</th>
                        <th>${f:getMessage("page.game.date")}</th>
                        <th>${f:getMessage("page.game.status")}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${gameList}" var="game">
                        <c:if test='${game.status.equals("ожидание")}'>
                            <tr data-href="/game/go?uuid=${game.uuid}">
                                <td class="user-name">${game.member1}</td>
                                <td class="user-email">${game.member2}</td>
                                <td class="user-phone">${game.headline}</td>
                                <td class="user-phone">${game.getStrokesCount()}</td>
                                <td class="user-mobile">${game.time}</td>
                                <td class="user-mobile">${game.status}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab3">
                <table>
                    <thead>
                    <tr>
                        <th>${f:getMessage("page.game.member")}</th>
                        <th>${f:getMessage("page.game.member")}</th>
                        <th>${f:getMessage("page.game.headline")}</th>
                        <th>${f:getMessage("page.game.strokes")}</th>
                        <th>${f:getMessage("page.game.date")}</th>
                        <th>${f:getMessage("page.game.status")}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${gameList}" var="game">
                        <c:if test='${game.status.equals("завершена")}'>
                            <tr data-href="/game/go?uuid=${game.uuid}">
                                <td class="user-name">${game.member1}</td>
                                <td class="user-email">${game.member2}</td>
                                <td class="user-phone">${game.headline}</td>
                                <td class="user-phone">${game.getStrokesCount()}</td>
                                <td class="user-mobile">${game.time}</td>
                                <td class="user-mobile">${game.status}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


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
