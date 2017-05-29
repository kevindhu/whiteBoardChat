var messageTextArea = document.getElementById("messageTextArea");
var textInput = document.getElementById("textInput");

function defineMessage() {
    var text = textInput.value;
    if (text != null) {
        var json = JSON.stringify(
            {
                "type" : "text",
                "chatText": text,
            });
        websocket.send(json);
        writeChatMsg(json);
    }
}

function writeChatMsg(msg) {
    var json = JSON.parse(msg);
    addMessage(json.chatText);
}

function addMessage(text) {
    messageTextArea.value += text + "\n";
}