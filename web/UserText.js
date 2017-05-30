var users = document.getElementById("users");

function updateUsers(message) {
    var json = JSON.parse(message);
    users.value = "";
    for (var i = 0; i<json.userNames.length; i++) {
        users.value += json.userNames[i] + "\n";
    }
}