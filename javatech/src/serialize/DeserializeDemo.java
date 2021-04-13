package serialize;

import com.google.gson.*;

public class DeserializeDemo {

    public static void main(String[] args) {
        String json = "[{'fieldCode':'name','fieldValue':'harrypotter'},{'fieldCode':'age','fieldValue':14}]";
        Gson gson = new GsonBuilder().registerTypeAdapter(MyEntity.class, new DeserializeUtil()).create();
        MyEntity myEntity = gson.fromJson(json, MyEntity.class);
        System.out.println(gson.toJson(myEntity));
    }

}
