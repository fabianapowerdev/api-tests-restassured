package api.payload;

import java.util.HashMap;
import java.util.Map;

public class PostPayload {

    public static Map<String, Object> create() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Post Fluxo");
        payload.put("body", "Criado via framework");
        payload.put("userId", 1);
        return payload;
    }

    public static Map<String, Object> update(int id) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("title", "Post Atualizado");
        payload.put("body", "Atualizado via framework");
        payload.put("userId", 1);
        return payload;
    }
}