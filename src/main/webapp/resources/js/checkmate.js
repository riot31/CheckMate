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
            //double swap
            //dragSrcEl.innerHTML = '<div class="item">&emsp;</div>';
            //this.innerHTML = e.dataTransfer.getData('text/html');
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
    [].forEach.call(items, function (col) {
        if (color == "black" && col.querySelectorAll("[class*='black']").length > 0 && currentUser == blackUser) {
            col.addEventListener('dragstart', handleDragStart, false);
        }
        if (color == "white" && col.querySelectorAll("[class*='white']").length > 0 && currentUser == whiteUser) {
            col.addEventListener('dragstart', handleDragStart, false);
        }
    });
}


[].forEach.call(items, function (col) {
    col.addEventListener('dragenter', handleDragEnter, false);
    col.addEventListener('dragover', handleDragOver, false);
    col.addEventListener('dragleave', handleDragLeave, false);
    col.addEventListener('drop', handleDrop, false);
    col.addEventListener('dragend', handleDragEnd, false);
});
if (strokes.length > 0) {
    [].forEach.call(strokes, function (message) {
        runStroke(message);
    });

}

function runStroke(coordination) {
    var tempStroke = coordination.split(" ");
    parent.children[Number(tempStroke[1])].innerHTML = parent.children[Number(tempStroke[0])].innerHTML;
    parent.children[Number(tempStroke[0])].innerHTML = '<div class="item">&emsp;</div>';
}

(function () {
    if (strokes.length % 2 == 0) {
        changeDragStart("white");
    } else {
        changeDragStart("black");
    }
}());


//chat
var socket = new SockJS("/room")
var stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe("/topic/" + gameUuid, function (message) {
        if (JSON.parse(message.body).type == "message") {
            if (JSON.parse(message.body).username == currentUser) {
                showMessageSelf(JSON.parse(message.body).message);
            } else {
                showMessageOther(JSON.parse(message.body).message);
            }
            doc.getElementById("message").value = "";
        } else {
            showStroke(JSON.parse(message.body).username, JSON.parse(message.body).message);
        }

        scrollDown();
    })
});

function sendMessage() {
    var message = doc.getElementById("message").value;
    if (message != "") {
        stompClient.send("/checkmate/room/" + gameUuid, {}, JSON.stringify({
            "message": message,
            "type": "message",
            "username": currentUser
        }));

    }
}

function sendStroke(stroke) {
    stompClient.send("/checkmate/room/" + gameUuid, {}, JSON.stringify({
        "message": stroke,
        "type": "stroke",
        "username": currentUser
    }));
}

function showMessageOther(message) {
    $('#discussion').append('<li class="other"><div class="avatar"><img src="http://s3-us-west-2.amazonaws.com/s.cdpn.io/3/profile/profile-80_20.jpg" /></div><div class="messages"><xmp>' + message + '</xmp></div></li>');
}

function showMessageSelf(message) {
    $('#discussion').append('<li class="self"><div class="avatar"><img src="http://s3-us-west-2.amazonaws.com/s.cdpn.io/5/profile/profile-80_9.jpg" /></div><div class="messages"><xmp>' + message + '</xmp></div></li>');
}

function showStroke(from, message) {
    $('#discussion').append('<li class="stroke"><p><em><b>' + from + '</b> ' + message + '</em></p></li>');
    runStroke(message);
    if (from == whiteUser) {
        changeDragStart("black");
    } else {
        changeDragStart("white");
    }
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
}())