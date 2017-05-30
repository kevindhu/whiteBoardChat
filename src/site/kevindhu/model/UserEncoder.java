package site.kevindhu.model;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


public class UserEncoder implements Encoder.Text<UserMessage> {
    public String encode(UserMessage users) throws EncodeException {
        JsonObjectBuilder ret = Json.createObjectBuilder()
                .add("type", "userMessage");

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for (String client: users.clients()) {
                jsonArrayBuilder.add(client);
        }
        ret.add("userNames",jsonArrayBuilder);
        return ret.build().toString();
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


