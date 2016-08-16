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

<h3 id="targetStroke" class="stroke-black">Loading...</h3>
<div class="right">
    <label class="btn btn-form" for="modal-surrender">${f:getMessage("game.surrender")}</label>
</div>


<div class="columns">
    <div class="column" draggable="true" title="A8 - 0">
        <div class="pieces castle-black"></div>
    </div>
    <div class="column" draggable="true" title="B8 - 1">
        <div class="pieces knight-black"></div>
    </div>
    <div class="column" draggable="true" title="C8 - 2">
        <div class="pieces bishop-black"></div>
    </div>
    <div class="column" draggable="true" title="D8 - 3">
        <div class="pieces queen-black"></div>
    </div>
    <div class="column" draggable="true" title="E8 - 4">
        <div class="pieces king-black"></div>
    </div>
    <div class="column" draggable="true" title="F8 - 5">
        <div class="pieces bishop-black"></div>
    </div>
    <div class="column" draggable="true" title="G8 - 6">
        <div class="pieces knight-black"></div>
    </div>
    <div class="column" draggable="true" title="H8 - 7">
        <div class="pieces castle-black"></div>
    </div>
    <div class="column" draggable="true" title="A7 - 8">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true" title="B7 - 9">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true" title="C7 - 10">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true" title="D7 - 11">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true" title="E7 - 12">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true" title="F7 - 13">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true" title="G7 - 14">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true" title="H7 - 15">
        <div class="pieces pawn-black"></div>
    </div>
    <div class="column" draggable="true" title="A6 - 16">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="B6 - 17">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="C6 - 18">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="D6 - 19">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="E6 - 20">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="F6 - 21">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="G6 - 22">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="H6 - 23">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="A5 - 24">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="B5 - 25">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="C5 - 26">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="D5 - 27">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="E5 - 28">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="F5 - 29">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="G5 - 30">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="H5 - 31">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="A4 - 32">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="B4 - 33">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="C4 - 34">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="D4 - 35">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="E4 - 36">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="F4 - 37">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="G4 - 38">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="H4 - 39">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="A3 - 40">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="B3 - 41">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="C3 - 42">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="D3 - 43">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="E3 - 44">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="F3 - 45">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="G3 - 46">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="H3 - 47">
        <div class="item">&emsp;</div>
    </div>
    <div class="column" draggable="true" title="A2 - 48">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true" title="B2 - 49">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true" title="C2 - 50">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true" title="D2 - 51">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true" title="E2 - 52">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true" title="F2 - 53">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true" title="G2 - 54">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true" title="H2 - 55">
        <div class="pieces pawn-white"></div>
    </div>
    <div class="column" draggable="true" title="A1 - 56">
        <div class="pieces castle-white"></div>
    </div>
    <div class="column" draggable="true" title="B1 - 57">
        <div class="pieces knight-white"></div>
    </div>
    <div class="column" draggable="true" title="C1 - 58">
        <div class="pieces bishop-white"></div>
    </div>
    <div class="column" draggable="true" title="D1 - 59">
        <div class="pieces queen-white"></div>
    </div>
    <div class="column" draggable="true" title="E1 - 60">
        <div class="pieces king-white"></div>
    </div>
    <div class="column" draggable="true" title="F1 - 61">
        <div class="pieces bishop-white"></div>
    </div>
    <div class="column" draggable="true" title="G1 - 62">
        <div class="pieces knight-white"></div>
    </div>
    <div class="column" draggable="true" title="H1 - 63">
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
                    <p><em><b>${message.username}</b> ${f:castToStroke(message.message)}</em></p>
                </li>
            </c:if>
            <c:if test="${message.type == 'end'}">
                <li class="end">
                    <p>${message.message}</p>
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

<div id="safe">

</div>


<div class="modal">
    <input type="checkbox" class="modal-open" id="modal-surrender" hidden/>

    <div class="modal-wrap" aria-hidden="true" role="dialog">
        <label for="modal-surrender" class="modal-overlay"></label>

        <div class="modal-dialog">
            <div class="modal-header">
                <h2>${f:getMessage("game.surrender")}</h2>
                <label for="modal-surrender" class="btn-close" aria-hidden="true">×</label>
            </div>
            <div class="modal-body">
                <p>${f:getMessage("game.surrender.info")}</p>
                <input name="submit" class="btn btn-form" type="button" id="game-surrender"
                       value="${f:getMessage("game.surrender")}"/>
            </div>
        </div>
    </div>
</div>


<script>
    // init jsp
    var snd = new Audio("/resources/audio/ICQ.mp3"); // buffers automatically when created
    var gameUuid = "${game.uuid}";
    var strokes = [];
    var socketSuffix = "";
    var whiteUser = "${game.member1}";
    var blackUser = "${game.member2}";
    var statusGame = "${game.status}";
    var aTime;
    var bTime;

    if (blackUser == "${socketSuffix}") {
        socketSuffix = "/${socketSuffix}/";
    }

    <c:forEach items="${strokeList}" var="stroke">
    strokes.push("${stroke.message}");
    </c:forEach>

    //game
    var doc = document;
    var parent = doc.getElementsByClassName("columns")[0];

    var items = parent.getElementsByClassName("column");

    var dragSrcEl = null;

    var currentUser = doc.getElementById("username").textContent;

    var stroke = null;

    function parentIndexOf(el) {
        for (var i = 0; i < parent.children.length; i++) {
            if (parent.children[i] === el) {
                return i;
            }
        }
    }

    function showMove(e) {
        stroke = "";
        var e = e || event;
        var target = e.target || e.srcElement;
        for (var i = 0; i < parent.children.length; i++) {
            if (parent.children[i] == target) {
                stroke += i;
                if (parent.children[i].querySelectorAll("[class*='pawn']").length) {
                    showPawn(e, i);
                }

                if (parent.children[i].querySelectorAll("[class*='knight']").length) {
                    showKnight(e, i);
                }

                if (parent.children[i].querySelectorAll("[class*='castle']").length) {
                    showCastle(e, i);
                }

                if (parent.children[i].querySelectorAll("[class*='bishop']").length) {
                    showBishop(e, i);
                }

                if (parent.children[i].querySelectorAll("[class*='queen']").length) {
                    showQueen(e, i);
                }

                if (parent.children[i].querySelectorAll("[class*='king']").length) {
                    showKing(e, i);
                }
                break;
            }
        }
    }

    function showKing(e, index) {
        var flagBlack = parent.children[index].querySelectorAll("[class*='black']").length > 0;
        var strokeLengthDifference = 2;
        checkParty(flagBlack, index, index + 1, strokeLengthDifference);
        checkParty(flagBlack, index, index - 1, strokeLengthDifference);
        checkParty(flagBlack, index, index + 8, strokeLengthDifference);
        checkParty(flagBlack, index, index - 8, strokeLengthDifference);
        checkParty(flagBlack, index, index - 9, strokeLengthDifference);
        checkParty(flagBlack, index, index - 7, strokeLengthDifference);
        checkParty(flagBlack, index, index + 7, strokeLengthDifference);
        checkParty(flagBlack, index, index + 9, strokeLengthDifference);

    }

    function showQueen(e, index) {
        showCastle(e, index);
        showBishop(e, index);
    }

    function showBishop(e, index) {
        var flagBlack = parent.children[index].querySelectorAll("[class*='black']").length > 0;
        var strokeLengthDifference = 9;
        for (var i = 1; i <= index % 8; i++) {
            if (!checkParty(flagBlack, index, index - i - i * 8, strokeLengthDifference)) {
                break;
            }
        }

        for (var i = 1; i < 8 - index % 8; i++) {
            if (!checkParty(flagBlack, index, index + i - i * 8, strokeLengthDifference)) {
                break;
            }
        }

        for (var i = 1; i <= index % 8; i++) {
            if (!checkParty(flagBlack, index, index - i + i * 8, strokeLengthDifference)) {
                break;
            }
        }

        for (var i = 1; i < 8 - index % 8; i++) {
            if (!checkParty(flagBlack, index, index + i + i * 8, strokeLengthDifference)) {
                break;
            }
        }
    }

    function showCastle(e, index) {
        var strokeLengthDifference = 9;
        var flagBlack = parent.children[index].querySelectorAll("[class*='black']").length > 0;
        for (var i = 1; i <= index % 8; i++) {
            if (!checkParty(flagBlack, index, index - i, strokeLengthDifference)) {
                break;
            }
        }
        for (var i = 1; i < 8 - index % 8; i++) {
            if (!checkParty(flagBlack, index, index + i, strokeLengthDifference)) {
                break;
            }
        }
        for (var i = index + 8; i < 64; i = i + 8) {
            if (!checkParty(flagBlack, index, i, strokeLengthDifference)) {
                break;
            }
        }
        for (var i = index - 8; i >= 0; i = i - 8) {
            if (!checkParty(flagBlack, index, i, strokeLengthDifference)) {
                break;
            }
        }
    }

    function showKnight(e, i) {
        var strokeLengthDifference = 3;
        var flagBlack = parent.children[i].querySelectorAll("[class*='black']").length > 0;
        checkParty(flagBlack, i, i - 17, strokeLengthDifference);
        checkParty(flagBlack, i, i + 17, strokeLengthDifference);
        checkParty(flagBlack, i, i - 15, strokeLengthDifference);
        checkParty(flagBlack, i, i + 15, strokeLengthDifference);
        checkParty(flagBlack, i, i - 10, strokeLengthDifference);
        checkParty(flagBlack, i, i + 10, strokeLengthDifference);
        checkParty(flagBlack, i, i - 6, strokeLengthDifference);
        checkParty(flagBlack, i, i + 6, strokeLengthDifference);

    }

    //Если flagBlack = true, тогда this фигура чёрная strokeLengthDifference нужно для выявления выхода за границы доски, strokeLengthDifference содержит информацию на сколько позиций может сместиться фигура отсительно столбцов доски
    function checkParty(flagBlack, index, position, strokeLengthDifference) {
        if (parent.children[position] && (Math.abs(index % 8 - position % 8) < strokeLengthDifference)) {
            if (flagBlack) {
                if (parent.children[position].querySelectorAll("[class*='black']").length) {
                    return false;
                }
                parent.children[position].classList.add("action");
                return !parent.children[position].querySelectorAll("[class^='pieces']").length;

            } else {
                if (parent.children[position].querySelectorAll("[class*='white']").length) {
                    return false;
                }
                parent.children[position].classList.add("action");
                return !parent.children[position].querySelectorAll("[class^='pieces']").length;

            }
        }
        return false;
    }

    function showPawn(e, i) {
        var strokeLengthDifference = 2;
        if (parent.children[i].getElementsByClassName("pawn-black").length) {
            if (parent.children[i + 7]) {
                if (parent.children[i + 7].querySelectorAll("[class*='white']").length) {
                    checkParty(true, i, i + 7, strokeLengthDifference);
                }
            }
            if (parent.children[i + 9]) {
                if (parent.children[i + 9].querySelectorAll("[class*='white']").length) {
                    checkParty(true, i, i + 9, strokeLengthDifference);
                }
            }
            if (parent.children[i + 8]) {
                if (parent.children[i + 8].querySelectorAll("[class^='pieces']").length == 0) {
                    parent.children[i + 8].classList.add("action");
                    if (parent.children[i + 16] && i / 8 >= 1 && i / 8 < 2) {
                        parent.children[i + 16].classList.add("action");
                    }
                }
            }
        }

        if (parent.children[i].getElementsByClassName("pawn-white").length) {
            if (parent.children[i - 7]) {
                if (parent.children[i - 7].querySelectorAll("[class*='black']").length) {
                    checkParty(false, i, i - 7, strokeLengthDifference);
                }
            }
            if (parent.children[i - 9]) {
                if (parent.children[i - 9].querySelectorAll("[class*='black']").length) {
                    checkParty(false, i, i - 9, strokeLengthDifference);
                }
            }
            if (parent.children[i - 8]) {
                if (parent.children[i - 8].querySelectorAll("[class^='pieces']").length == 0) {
                    parent.children[i - 8].classList.add("action");
                    if (parent.children[i - 16] && i / 8 >= 6 && i / 8 < 7) {
                        parent.children[i - 16].classList.add("action");
                    }
                }
            }
        }
    }

    function handleDragStart(e) {
        showMove(e);
        this.style.opacity = '0.4';
        dragSrcEl = this;

        e.dataTransfer.effectAllowed = 'move';
        e.dataTransfer.setData('text/html', this.innerHTML);
    }

    function handleDragOver(e) {
        if (e.preventDefault) {
            e.preventDefault();
        }

        e.dataTransfer.dropEffect = 'move';
        return false;
    }

    function handleDragEnter(e) {
        this.classList.add('over');
    }

    function handleDragLeave(e) {
        this.classList.remove('over');
    }

    function handleDrop(e) {
        if (e.stopPropagation) {
            e.stopPropagation();
        }

        if (dragSrcEl != this) {
            if (this.classList.contains('action')) {
                [].forEach.call(items, function (col) {
                    col.removeEventListener('dragstart', handleDragStart, false);
                });
                stroke += " " + parentIndexOf(this);
                sendStroke(stroke);
            }
        }
        return false;
    }


    function handleDragEnd(e) {
        [].forEach.call(items, function (col) {
            col.classList.remove('over');
            col.classList.remove('action');
            col.style.opacity = 1;
        });
    }


    function changeDragStart(color) {
        setInfo(color);
        [].forEach.call(items, function (col) {
            if (color == "black" && col.querySelectorAll("[class*='black']").length > 0 && currentUser == blackUser) {
                col.addEventListener('dragstart', handleDragStart, false);
            }
            if (color == "white" && col.querySelectorAll("[class*='white']").length > 0 && currentUser == whiteUser) {
                col.addEventListener('dragstart', handleDragStart, false);
            }
        });
    }

    function setInfo(color) {
        var info = "${f:getMessage("game.stroke")} " + (color == 'white' ? whiteUser : blackUser);
        var el = doc.getElementById("targetStroke");
        el.innerHTML =info;
        if (color == 'white') {
            el.className = "stroke-white";
        } else {
            el.className = "stroke-black";
        }
    }

    function runStroke(coordination) {
        var tempStroke = coordination.split(" ");
        if (parent.children[Number(tempStroke[1])].querySelectorAll(".pieces").length > 0) {
            $('#safe').append(parent.children[Number(tempStroke[1])].innerHTML);
        }
        parent.children[Number(tempStroke[1])].innerHTML = parent.children[Number(tempStroke[0])].innerHTML;
        parent.children[Number(tempStroke[0])].innerHTML = '<div class="item">&emsp;</div>';
        if (statusGame !== "завершена") {
            if (parent.querySelectorAll("[class*='king']").length == 1) {
                statusGame = "завершена";
                if (parent.querySelector("[class*='king-wh")) {
                    sendEnd(whiteUser);
                } else {
                    sendEnd(blackUser);
                }
            }
        }
    }

    //chat
    var socket = new SockJS("/room");
    var stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe("/topic/" + gameUuid, function (message) {
            if (JSON.parse(message.body).type == "stroke") {
                bTime = Date.now();
                showTime(bTime - aTime);
                showStroke(JSON.parse(message.body).username, JSON.parse(message.body).message);
            } else if (JSON.parse(message.body).type == "message") {
                if (JSON.parse(message.body).username == currentUser) {
                    showMessageSelf(JSON.parse(message.body).message);
                } else {
                    showMessageOther(JSON.parse(message.body).message);
                }
            } else if (JSON.parse(message.body).type == "end") {
                showEnd(JSON.parse(message.body).message);
            } else if (JSON.parse(message.body).type == "performance") {
                blackUser = JSON.parse(message.body).message;
                activateButton();
            }
            scrollDown();
        });
        <c:if test="${not empty performance}">
            stompClient.send("/checkmate/room/performance/" + gameUuid, {}, JSON.stringify({
                "message": currentUser,
                "type": "performance",
                "username": currentUser
            }));
        </c:if>
    }, function (message) {
        // check message for disconnect
        $('#discussion').append('<li class="stroke"><p style="color: rgb(183, 183, 13);;"><em><b>' + '${f:getMessage("error.stomp.disconnect")}' + '</b></em></p></li>');
    });

    function showTime(time) {
        if (document.getElementById("targetStroke").innerHTML != "Ход: " + currentUser) {
            $('#discussion').append('<li class="stroke"><p><em><b>' + 'Время размышления' + '</b> ' + (time / 600) + '</em></p></li>');
        }
    }

    function sendMessage() {
        var message = doc.getElementById("message").value;
        doc.getElementById("message").value = "";
        if (message != "") {
            stompClient.send("/checkmate/room/" + gameUuid, {}, JSON.stringify({
                "message": message,
                "type": "message",
                "username": currentUser
            }));
        }
    }

    function sendStroke(stroke) {
        aTime = Date.now();
        stompClient.send("/checkmate/room/" + socketSuffix + gameUuid, {}, JSON.stringify({
            "message": stroke,
            "type": "stroke",
            "username": currentUser
        }));
        if (socketSuffix !== "") {
            showStroke(currentUser, stroke);
        }
    }

    function sendEnd(user) {
        stompClient.send("/checkmate/room/end/" + gameUuid, {}, JSON.stringify({
            "message": user + " win!",
            "type": "end",
            "username": user
        }));
    }

    function showMessageOther(message) {
        $('#discussion').append('<li class="other"><div class="avatar"><img src="http://s3-us-west-2.amazonaws.com/s.cdpn.io/3/profile/profile-80_20.jpg" /></div><div class="messages"><xmp>' + message + '</xmp></div></li>');
    }

    function showMessageSelf(message) {
        $('#discussion').append('<li class="self"><div class="avatar"><img src="http://s3-us-west-2.amazonaws.com/s.cdpn.io/5/profile/profile-80_9.jpg" /></div><div class="messages"><xmp>' + message + '</xmp></div></li>');
    }

    function showStroke(from, message) {
        $('#discussion').append('<li class="stroke"><p><em><b>' + from + '</b> ' + getStroke(message) + '</em></p></li>');
        if (from !== currentUser) {
            snd.play();
        }
        runStroke(message);

        if (from == whiteUser) {
            changeDragStart("black");
        } else {
            changeDragStart("white");
        }
    }

    function showEnd(message) {
        $('#discussion').append('<li class="end"><p>' + message + '</p></li>');
        [].forEach.call(items, function (col) {
            col.removeEventListener('dragstart', handleDragStart, false);
        });
        document.getElementById("targetStroke").innerHTML = "Игра завершена";

    }

    function scrollDown() {
        var discussion = doc.getElementById('discussion');
        $("#discussion").animate({scrollTop: discussion.scrollHeight}, 400);
    }

    var sender = doc.getElementById('sender');
    sender.addEventListener('click', sendMessage, false);
    document.querySelector('#message').addEventListener('keypress', function (e) {
        var key = e.which || e.keyCode;
        if (key === 13) {
            sendMessage();
        }
    });


    //scroll dow
    (function () {
        scrollDown();
    }());


    function getStroke(message) {
        var coordinate = message.split(" ");
        var notations = [
            "A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8",
            "A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7",
            "A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6",
            "A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5",
            "A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4",
            "A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3",
            "A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2",
            "A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1"
        ];
        return " походил с " + notations[coordinate[0]] + " на " + notations[coordinate[1]];
    }
    $(document).ready(function () {
        if (strokes.length > 0) {
            [].forEach.call(strokes, function (message, index) {
                setTimeout(runStroke, 300 * index, message);
            });
        }

        if (blackUser === "" || (currentUser != whiteUser && currentUser != blackUser)) {
            disableButton();
        }

        setTimeout(function () {
            if (statusGame != 'завершена') {
                [].forEach.call(items, function (col) {
                    col.addEventListener('dragenter', handleDragEnter, false);
                    col.addEventListener('dragover', handleDragOver, false);
                    col.addEventListener('dragleave', handleDragLeave, false);
                    col.addEventListener('drop', handleDrop, false);
                    col.addEventListener('dragend', handleDragEnd, false);
                });
                (function () {


                    if (strokes.length % 2 == 0) {
                        changeDragStart("white");
                    } else {
                        changeDragStart("black");
                    }
                }());
            } else {
                document.getElementById("targetStroke").innerHTML = "Игра завершена";
            }
        }, 300 * strokes.length);

    });

    doc.getElementById("game-surrender").addEventListener("click", gameSurrender, false);
    function gameSurrender() {
        var lossUser = currentUser === whiteUser ? sendEnd(blackUser) : sendEnd(whiteUser);
        $('#modal-surrender').click();
    }

    function disableButton() {
        document.getElementById("game-surrender").disabled = true;
    }

    function activateButton() {
        document.getElementById("game-surrender").disabled = false;
    }

</script>

</body>
</html>
