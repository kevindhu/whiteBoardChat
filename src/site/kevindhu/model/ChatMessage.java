package site.kevindhu.model;

import javax.json.JsonObject;

public class ChatMessage implements Message{
    private String username;
    private String message;
    private JsonObject json;

    public ChatMessage(JsonObject json) {
        this.message = json.getString("message");
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
