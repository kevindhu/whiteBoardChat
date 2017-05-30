var messageTextArea = document.getElementById("messageTextArea");
var textInput = document.getElementById("textInput");

function defineMessage() {
    var text = textInput.value;
    if (text != null) {
        var json = JSON.stringify(
            {
                "type": "chatMessage",
                "chatText": text
            });
        websocket.send(json);
        textInput.value = "";
        alert(json);
    }
}

function writeChatMsg(msg) {
    alert("writing message");
    var json = JSON.parse(msg);
    addMessage(json.username + " : " + json.chatText);
}

function addMessage(text) {
    messageTextArea.value += text + "\n";
}