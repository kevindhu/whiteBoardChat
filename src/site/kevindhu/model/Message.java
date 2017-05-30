package site.kevindhu.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.StringWriter;

public interface Message {

    public JsonObject getJson();

    public void setJson(JsonObject obj);

    public String toString();

}



