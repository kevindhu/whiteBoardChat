package site.kevindhu.model;

import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class UserMessage implements Message {
    private List<String> clients;

    public UserMessage() {
        this.clients = new ArrayList<>();
    }

    public List<String> clients() {
        return clients;
    }

    public JsonObject getJson() {
        return null;
    }

    public void setJson(JsonObject obj) {
        return;
    }

    public String toString() {
        return super.toString();
    }



}
