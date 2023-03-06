
var webSocket = null;
function ajaxCallBack(responseTxt, statusTxt, xhr) {
    if (statusTxt == "success") {
        alert("External content loaded successfully!");
    }
}

$(document).ready(function () {
    $("submit").click(function () {
        connect();
        $.get("view/pages/chatPage.html", ajaxCallBack);
    });
});

function connect() {
    webSocket = new WebSocket("ws:http://localhost:8080/MG1/chat");
    webSocket.onopen = onOpen;
    webSocket.onmessage = onMessage;
}

function onOpen() {
    console.log("connection establish")
}

function send() {
    let msg = document.getElementById("").value;
    webSocket.send(msg);
}

function onMessage(event) {
    console.log(event.data);
}