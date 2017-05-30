package site.kevindhu.model;

import javax.json.JsonObject;

public class ChatMessage implements Message{
    private String username;
    private String message;
    private JsonObject json;

    public ChatMessage(JsonObject json) {
        this.message = json.getString("chatText");
        this.json = json;
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

}
