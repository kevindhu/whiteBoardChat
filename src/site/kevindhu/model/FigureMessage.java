package site.kevindhu.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.StringWriter;

public class FigureMessage implements Message {
    private JsonObject json;

    public FigureMessage(JsonObject input) {
        this.json = input;
    }

    public JsonObject getJson() {
        return json;
    }

    public void setJson(JsonObject obj) {
        this.json = obj;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.write(json);
        return stringWriter.toString();
    }


}



