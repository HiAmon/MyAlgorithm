package serialize;

import com.google.gson.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class DeserializeUtil implements JsonDeserializer<MyEntity> {
    @Override
    public MyEntity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        MyEntity entity = new MyEntity();
        if (jsonElement.isJsonArray()){
            Field[] declaredFields = MyEntity.class.getDeclaredFields();
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            for(Field field:declaredFields){
                for (JsonElement element:jsonArray){
                    //这里为什么要加两层括号才不会报错？
                    String fieldKey = ((JsonObject)element).get("fieldCode").getAsString();
                    String fieldValue = ((JsonObject)element).get("fieldValue").getAsString();
                    if (field.getName().equals(fieldKey)){
                        try {
                            field.set(entity,fieldValue);
                            field.setAccessible(true);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return entity;
    }
}
