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

<%--TODO: вынести js отсюда на хер--%>
<script>
//    game
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
                    if (parent.children[i + 16]) {
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
                    if (parent.children[i - 16]) {
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
                dragSrcEl.innerHTML = '<div class="item">&emsp;</div>';
                this.innerHTML = e.dataTransfer.getData('text/html');
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

    [].forEach.call(items, function (col) {
        col.addEventListener('dragenter', handleDragEnter, false);
        col.addEventListener('dragover', handleDragOver, false);
        col.addEventListener('dragleave', handleDragLeave, false);
        col.addEventListener('drop', handleDrop, false);
        col.addEventListener('dragend', handleDragEnd, false);
    });


    function changeDragStart(color) {
        [].forEach.call(items, function (col) {
            if (color == "black" && col.querySelectorAll("[class*='black']")) {
                col.addEventListener('dragstart', handleDragStart, false);
            }
            if (color == "white" && col.querySelectorAll("[class*='white']")) {
                col.addEventListener('dragstart', handleDragStart, false);
            }
        });
    }
</script>



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
                <script>
                    (function () {
                        var tempArr = "${message.message}".split(" ");
                        //stroke
                        parent.children[Number(tempArr[1])].innerHTML = parent.children[Number(tempArr[0])].innerHTML;
                        parent.children[Number(tempArr[0])].innerHTML = '<div class="item">&emsp;</div>';
                    }())
                </script>
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

    //chat
    //TODO: сделать показ stroke с вызовом changeDragStart
    var socket = new SockJS("/room")
    var stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe("/topic/${game.uuid}", function (message) {
            if (JSON.parse(message.body).username == currentUser) {
                showMessageSelf(JSON.parse(message.body).message);
            } else {
                showMessageOther(JSON.parse(message.body).message);
            }
            scrollDown();
            doc.getElementById("message").value = "";
        })
    });

    function sendMessage() {
        var message = doc.getElementById("message").value;
        if (message != "") {
            stompClient.send("/checkmate/room/${game.uuid}", {}, JSON.stringify({
                "message": message,
                "type": "message",
                "username": "${username}"
            }));

        }
    }

    function sendStroke(stroke) {
        stompClient.send("/checkmate/room/${game.uuid}", {}, JSON.stringify({
            "message": stroke,
            "type": "stroke",
            "username": "${username}"
        }));
    }

    function showMessageOther(message) {
        $('#discussion').append('<li class="other"><div class="avatar"><img src="http://s3-us-west-2.amazonaws.com/s.cdpn.io/3/profile/profile-80_20.jpg" /></div><div class="messages"><xmp>' + message + '</xmp></div></li>');
    }

    function showMessageSelf(message) {
        $('#discussion').append('<li class="self"><div class="avatar"><img src="http://s3-us-west-2.amazonaws.com/s.cdpn.io/5/profile/profile-80_9.jpg" /></div><div class="messages"><xmp>' + message + '</xmp></div></li>');
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
</script>

</body>
</html>
