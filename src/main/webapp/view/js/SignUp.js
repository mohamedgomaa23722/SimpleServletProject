
var userreq = null;
var passwrodreq = null;
var cPaswordreq = null;
var simpleReq = null;

function submitUserName() {
    if (window.XMLHttpRequest)
        userreq = new XMLHttpRequest();
    else if (window.ActiveXObject)
        userreq = new ActiveXObject(Microsoft.XMLHTTP);
    userreq.onreadystatechange = handleUserNameReq;
    let userName = document.getElementById("userName").value;
    let url = "validate" + "?userName=" + userName + "&state=0&timeStamp=" + new Date().getTime();
    userreq.open("GET", url, true)
    userreq.send(null);
}

function submitPassword() {
    if (window.XMLHttpRequest)
        passwrodreq = new XMLHttpRequest();
    else if (window.ActiveXObject)
        passwrodreq = new ActiveXObject(Microsoft.XMLHTTP);
    passwrodreq.onreadystatechange = handlePasswordReq;
    let password = document.getElementById("password").value;
    let url = "validate?password=" + password + "&state=1" + "&timeStamp=" + new Date().getTime()
    passwrodreq.open("GET", url, true)
    passwrodreq.send(null)
}

function submitCPassword() {
    if (window.XMLHttpRequest)
        cPaswordreq = new XMLHttpRequest();
    else if (window.ActiveXObject)
        cPaswordreq = new ActiveXObject(Microsoft.XMLHTTP);
    cPaswordreq.onreadystatechange = handleCPasswordReq;
    let password = document.getElementById("password").value;
    let confirmPasswod = document.getElementById("cpassword").value;
    let url = "validate?password=" + password + "&cPassword=" + confirmPasswod + "&state=2" + "&timeStamp=" + new Date().getTime();
    cPaswordreq.open("GET", url, true)
    cPaswordreq.send(null)
}

function handleUserNameReq() {
    if (userreq.readyState == 4)
        if (userreq.status == 200) {
            let label = document.getElementById("userName_label")
            console.log("username resutl" + userreq.responseText)
            label.removeAttribute("hidden");
            label.innerHTML = userreq.responseText;
        }
        else
            console.log(
                "Error code " + userreq.status)
}

function handlePasswordReq() {
    if (passwrodreq.readyState == 4)
        if (passwrodreq.status == 200) {
            let label = document.getElementById("password_label")
            console.log("pass resutl" + passwrodreq.responseText)
            label.removeAttribute("hidden");
            label.innerHTML = passwrodreq.responseText;
        }
        else
            console.log(
                "Error code " + passwrodreq.status)

}

function handleCPasswordReq() {
    if (cPaswordreq.readyState == 4)
        if (cPaswordreq.status == 200) {
            let label = document.getElementById("cpassword_label")
            console.log("pass resutl" + cPaswordreq.responseText)
            label.removeAttribute("hidden");
            label.innerHTML = cPaswordreq.responseText;
        }
        else
            console.log(
                "Error code " + cPaswordreq.status)
}

function getData() {
    console.log("correct")
    if (window.XMLHttpRequest)
        simpleReq = new XMLHttpRequest();
    else if (window.ActiveXObject)
        simpleReq = new ActiveXObject(Microsoft.XMLHTTP);
    simpleReq.onreadystatechange = handleSimpleReq;
    let url = "validate?timeStamp=" + new Date().getTime();
    simpleReq.open("POST", url, true)
    simpleReq.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    simpleReq.send("name=gomaa")

}

function handleSimpleReq() {
    if (simpleReq.readyState == 4)
        if (simpleReq.status == 200) {
            console.log("correct")
            let label = document.getElementById("text")
            label.value = simpleReq.responseText;
        }
        else
            console.log(
                "Error code " + cPaswordreq.status)
}
var xmlHttp;

function startRequest() {
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = handleStateChange;
    xmlHttp.open("GET", "Data.txt?timeStamp=" + new Date().getTime(), true);
    xmlHttp.send(null);
}

function createXMLHttpRequest() {
    if (window.ActiveXObject)
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    else if (window.XMLHttpRequest)
        xmlHttp = new XMLHttpRequest();
}

function handleStateChange() {
    if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
        document.getElementById("results").innerHTML =
            xmlHttp.responseText;
            document.getElementById("results").classList.add("table");

}