package site.kevindhu.model;

import javax.json.JsonObject;

public class ChatMessage implements Message{
    private String username;
    private String message;
    private JsonObject json;
    private String updateStatus;

    public ChatMessage(JsonObject json) {
        this.message = json.getString("message");
        this.json = json;
        this.updateStatus = "false";
    }


    @Override
    public JsonObject getJson() {
        return json;
    }

    @Override
    public void setJson(JsonObject json) {
        this.json = json;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUsername(String message) {
        this.username = message;
    }


    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public void setUpdateStatus(String status) {
        updateStatus = status;
    }

    public String updateStatus() {
        return updateStatus;
    }

}
