// Define o pacote onde essa classe está.
// Aqui ficam as classes que montam o "payload" (corpo) das requisições.
package api.payload;

// Importa o HashMap, que é uma estrutura de dados do Java.
// Ele serve para guardar pares "chave → valor".
// Exemplo: "title" → "Post Fluxo"
import java.util.HashMap;

// Importa a interface Map, que é o "tipo" mais genérico para mapas.
// A gente usa Map para devolver algo que pode ser HashMap por baixo.
import java.util.Map;


// Classe responsável por construir os corpos (bodies) das requisições.
// Ela NÃO faz chamada HTTP, NÃO valida nada e NÃO é um teste.
// Ela apenas monta dados reutilizáveis.
public class PostPayload {

    // ---------------------------------------------------------
    // MÉTODO PARA CRIAR UM PAYLOAD DE POST (CRIAÇÃO)
    // ---------------------------------------------------------
    // Retorna um Map com os campos que a API espera para criar um post.
    // Map<String, Object> significa:
    // - String: as chaves do JSON (ex: "title", "body")
    // - Object: os valores podem ser texto, número, etc.
    public static Map<String, Object> create() {

        // Cria um "mapa" vazio para montar o JSON.
        // Pense nisso como uma "caixinha" onde vamos colocar os campos.
        Map<String, Object> payload = new HashMap<>();

        // Adiciona o campo "title" no payload.
        // Isso vira no JSON:
        // "title": "Post Fluxo"
        payload.put("title", "Post Fluxo");

        // Adiciona o campo "body" (o conteúdo do post).
        // Isso vira no JSON:
        // "body": "Criado via framework"
        payload.put("body", "Criado via framework");

        // Adiciona o campo "userId" (id do usuário).
        // Isso vira no JSON:
        // "userId": 1
        payload.put("userId", 1);

        // Devolve o payload pronto para ser enviado no POST.
        return payload;
    }


    // ---------------------------------------------------------
    // MÉTODO PARA CRIAR UM PAYLOAD DE PUT (ATUALIZAÇÃO)
    // ---------------------------------------------------------
    // Recebe um id (do post) e devolve um Map com os campos para atualizar.
    public static Map<String, Object> update(int id) {

        // Cria um mapa vazio para montar o JSON de atualização.
        Map<String, Object> payload = new HashMap<>();

        // Coloca o "id" dentro do body.
        // Algumas APIs exigem isso; outras não.
        // Aqui usamos porque é didático e combina com o JSONPlaceholder.
        payload.put("id", id);

        // Atualiza o título.
        payload.put("title", "Post Atualizado");

        // Atualiza o conteúdo do post.
        payload.put("body", "Atualizado via framework");

        // Mantém o userId.
        payload.put("userId", 1);

        // Devolve o payload pronto para ser enviado no PUT.
        return payload;
    }
}
