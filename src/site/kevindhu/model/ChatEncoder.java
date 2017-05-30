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
                .add("type", json.getString("type"))
                .add("username",chat.getUsername())
                .add("chatText",chat.getMessage())
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


