var wsUri = "ws://" + document.location.host + document.location.pathname + "whiteboardendpoint";
var websocket = new WebSocket(wsUri);
var output = document.getElementById("output");


websocket.onopen = function (message) {
    onOpen(message)
};
websocket.onerror = function (message) {
    onError(message)
};
websocket.onmessage = function (message) {
    onMessage(message);
};


function onError(message) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + message.data);
}


function onOpen(message) {
    writeToScreen("Connected to " + wsUri);
}


function onMessage(message) {
    var json = JSON.parse(message.data);
    if (json.type == "drawMessage") {
        drawImageText(message.data);
    }
    else if (json.type == "chatMessage") {
        writeChatMsg(message.data);
    }
    else if (json.type == "userMessage") {
        updateUsers(message.data);
    }
}


function writeToScreen(message) {
    output.innerHTML += message + "<br>";
}
