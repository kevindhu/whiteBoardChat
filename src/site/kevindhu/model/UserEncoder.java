package site.kevindhu.model;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


public class UserEncoder implements Encoder.Text<UserMessage> {

    @Override
    public String encode(UserMessage users) throws EncodeException {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for (String client: users.clients()) {
                jsonArrayBuilder.add(client);
        }
        return Json.createObjectBuilder()
                .add("type", "userMessage")
                .add("userNames",jsonArrayBuilder)
                .build().toString();
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


