var doc = document;
//ajax
function getRivals() {
    $.get("/rivals", function (returnedData) {
        [].forEach.call(returnedData, function (col) {
            $('#rivals').append('<option value="' + col + '">');
        })
    });
}
doc.getElementById('createGame').addEventListener('click', getRivals, false);