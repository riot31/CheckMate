var doc = document;
var parent = doc.getElementsByClassName("columns")[0];

var items = parent.getElementsByClassName("column");

var dragSrcEl = null;

function showMove(e) {
    var e = e || event;
    var target = e.target || e.srcElement;
    for (var i = 0; i < parent.children.length; i++) {
        if (parent.children[i] == target) {
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
    col.addEventListener('dragstart', handleDragStart, false);
    col.addEventListener('dragenter', handleDragEnter, false);
    col.addEventListener('dragover', handleDragOver, false);
    col.addEventListener('dragleave', handleDragLeave, false);
    col.addEventListener('drop', handleDrop, false);
    col.addEventListener('dragend', handleDragEnd, false);
});