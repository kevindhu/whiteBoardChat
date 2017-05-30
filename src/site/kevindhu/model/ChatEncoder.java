package site.kevindhu.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


public class ChatEncoder implements Encoder.Text<ChatMessage> {
    public String encode(ChatMessage chat) throws EncodeException {
        JsonObject json = chat.getJson();
        JsonObject ret = Json.createObjectBuilder()
                .add("type", "chat")
                .add("username",chat.getUsername())
                .add("message",json.getString("message"))
                .add("updateStatus",chat.updateStatus())
                .build();
        return ret.toString();
    }

    @Override
    public void init(EndpointConfig ec) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

}


