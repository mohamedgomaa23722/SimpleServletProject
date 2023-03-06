var req;

function loadJSONFromServlet() {
    var url = "home?search=" +
        document.getElementById("searchValue").value;
    createXMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.readyState == 4 && req.status == 200)
            populateJSON();
    }
    req.open("GET", url, true);
    req.send();
}

function createXMLHttpRequest() {
    if (window.ActiveXObject)
        req = new ActiveXObject("Microsoft.XMLHTTP");
    else if (window.XMLHttpRequest)
        req = new XMLHttpRequest();
}

function populateJSON() {
    var jsonData = req.responseText;
    var myJSONObject = eval('(' + jsonData + ')');
    let tabel = "<table id = \"table\"> <tr> <th>id</th> <th>userName</th> <th>BithDate</th> </tr>";
    for (let index = 0; index < myJSONObject.length; index++) {

    }
    myJSONObject.forEach(element => {
        let id = element.id;
        let name = element.userName;
        let date = element.birthdate;
        tabel = tabel + "<tr> <td>" + id + "</td> <td>" + name + "</td> <td>" + date + "</td></tr>";
        console.log(`id = ${id}, name = ${name}, date = ${date}`)
    });
    tabel = tabel + "</tabel>";
    document.getElementById("result").innerHTML = tabel;
}