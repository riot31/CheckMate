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
</section>

<div id="safe" style="padding-top: 30px;">

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

    function setInfo(color) {
        if (statusGame != 'завершена') {
            var info = "${f:getMessage("game.stroke")} " + (color == 'white' ? whiteUser : blackUser);
            var el = doc.getElementById("targetStroke");
            el.innerHTML = info;
            if (color == 'white') {
                el.className = "stroke-white";
            } else {
                el.className = "stroke-black";
            }
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
            } else if (JSON.parse(message.body).type == "end") {
                showEnd(JSON.parse(message.body).message);
            }
            scrollDown();
        });
    }, function (message) {
        // check message for disconnect
        $('#discussion').append('<li class="stroke"><p style="color: rgb(183, 183, 13);;"><em><b>' + '${f:getMessage("error.stomp.disconnect")}' + '</b></em></p></li>');
    });

    function showTime(time) {
        if (document.getElementById("targetStroke").innerHTML != "Ход: " + currentUser) {
            $('#discussion').append('<li class="stroke"><p><em><b>' + 'Время размышления' + '</b> ' + (time / 600) + '</em></p></li>');
        }
    }

    function bootStroke(color) {
        if (statusGame != "завершена") {
            var bootName = color == 'black' ? blackUser : whiteUser;
            aTime = Date.now();
            stompClient.send("/checkmate/room/scramble/" + gameUuid, {}, JSON.stringify({
                bootName: bootName,
                isBlack: color == "black"
            }));
        }
    }

    function sendEnd(user) {
        stompClient.send("/checkmate/room/end/" + gameUuid, {}, JSON.stringify({
            "message": user + " win!",
            "type": "end",
            "username": user
        }));
    }

    function showStroke(from, message) {
        $('#discussion').append('<li class="stroke"><p><em><b>' + from + '</b> ' + getStroke(message) + '</em></p></li>');
        if (from !== currentUser) {
            snd.play();
        }
        runStroke(message);

        if (from == whiteUser) {
            setInfo("black");
            bootStroke("black");
        } else {
            setInfo("white");
            bootStroke("white");
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


        setTimeout(function () {
            if (statusGame != 'завершена') {
                if (strokes.length % 2 == 0) {
                    setInfo('white');
                    bootStroke('white');
                } else {
                    setInfo('black');
                    bootStroke('black');
                }
                //scroll dow
                (function () {
                    scrollDown();
                }());
            } else {
                document.getElementById("targetStroke").innerHTML = "Игра завершена";
            }
        }, 300 * strokes.length + 1000);

    });


</script>

</body>
</html>
