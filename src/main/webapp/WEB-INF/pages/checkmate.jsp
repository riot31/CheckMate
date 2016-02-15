<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="/WEB-INF/tags/functions.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Good game!</title>

    <script src="/resources/js/sockjs-0.3.4.js"></script>
    <script src="/resources/js/stomp.js"></script>
</head>
<body>

<div class="columns">
    <div class="column" draggable="true">
        <div class="pieces castle-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces knight-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces bishop-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces queen-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces king-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces bishop-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces knight-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces castle-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces castle-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces knight-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces bishop-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces queen-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces king-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces bishop-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces knight-white"></div>
    </div>
    <div class="column" draggable="true">
        <div class="pieces castle-white"></div>
    </div>
</div>

<section class="module">

    <header class="top-bar">

        <div class="left">
            <span class="icon typicons-message"></span>

            <h1>Hangouts</h1>
        </div>

        <div class="right">
            <span class="icon typicons-minus"></span>
            <span class="icon typicons-times"></span>
        </div>

    </header>

    <ol class="discussion" id="discussion">
        <c:forEach items="${game.messageList}" var="message">
            <c:if test="${message.username == username and message.type == 'message'}">
                <li class="self">
                    <div class="avatar">
                        <img src="http://s3-us-west-2.amazonaws.com/s.cdpn.io/3/profile/profile-80_20.jpg"/>
                    </div>
                    <div class="messages">
                        <p>${message.message}</p>
                    </div>
                </li>
            </c:if>
            <c:if test="${message.type == 'stroke'}">
                <li class="stroke">
                    <p><em><b>${message.username}</b> ${message.message}</em></p>
                </li>
            </c:if>

            <c:if test="${message.username != username and message.type == 'message'}">
                <li class="other">
                    <div class="avatar">
                        <img src="http://s3-us-west-2.amazonaws.com/s.cdpn.io/5/profile/profile-80_9.jpg"/>
                    </div>
                    <div class="messages">
                        <p>${message.message}</p>
                    </div>
                </li>
            </c:if>
        </c:forEach>
    </ol>
    <div class="send">
        <input id="message" type="text" placeholder="${f:getMessage("message.placeholder")}"/>
        <input type="button" value="send" id="sender"/>
    </div>
</section>
<script>



    // init jsp
    var gameUuid = "${game.uuid}";
    var strokes = [];
    var whiteUser = "${game.member1}";
    var blackUser = "${game.member2}";
    <c:forEach items="${strokeList}" var="stroke">
    strokes.push("${stroke.message}");
    </c:forEach>
</script>
<script src="/resources/js/checkmate.js"></script>

</body>
</html>
