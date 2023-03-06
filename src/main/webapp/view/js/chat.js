
var webSocket;
var Uname;

function login(){
    let name = document.getElementById("name").value;
    localStorage.setItem('name', name)
    console.log(name)
    let url = "http://localhost:8080/MG1/chat"
    document.location.href = url;
}

function connect() {
    console.log("connect......")
    Uname = localStorage.getItem('name');
    webSocket = new WebSocket('ws://localhost:8080/MG1/chatSocket?name=' + Uname);
    webSocket.onopen = onOpen;
    webSocket.onmessage = onMessage;
    
}

connect();

function onOpen() {
    console.log("connection establish")

}

function send() {
    let msg = document.getElementById("message").value;
    console.log(msg)
    let j = `{"name" : "${Uname}","message" :"${msg}"}`
    webSocket.send(j);
}

function onMessage(event) {
    let div = document.getElementById("messages");
    var myobj = JSON.parse(event.data);
    console.log(event.data)
    div.innerHTML +=  "<p>"+ myobj.name +" : " + myobj.message +"</p> <br>"
}