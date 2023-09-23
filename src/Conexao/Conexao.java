package Conexao;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Apod;
import entities.ApodJson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe que gerencia a conexão com uma das APIs da NASA.
 *
 *
 * @author Davi Maciel Cavalcante
 */

public class Conexao {

    private HttpClient cliente;
    private HttpRequest requisicao;

    public Conexao() {
    }
    public Conexao(String apiUrl, String chave) {
        this.cliente = HttpClient.newHttpClient();
        this.requisicao = HttpRequest.newBuilder().uri(URI.create(apiUrl + chave)).build();
    }

    public HttpRequest getRequest() {
        return requisicao;
    }

    private HttpResponse<String> resposta() {
        HttpResponse<String> resposta = null;

        try {
            resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return resposta;
    }

    public <T> Object respostaEmJson(int opcao) {
        String resposta = null;
        resposta = resposta().body();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (opcao == 1) {
            ApodJson respostaNaoFinalizada = gson.fromJson(resposta, ApodJson.class);
            Apod respostaFinalizada = new Apod(respostaNaoFinalizada);
            return respostaFinalizada;
        }
        return "";
    }
}