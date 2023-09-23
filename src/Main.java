import Conexao.Conexao;
import geradorDeArquivos.GeradorJson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String apiUrl = "https://api.nasa.gov/planetary/apod?api_key=";
        String chave = "Z3b9myFkowgyLaOUk1REyIBvLtbNPhsipwro4ia8";

        Conexao conexao = new Conexao(apiUrl, chave);
        GeradorJson.salvarJson(conexao.respostaEmJson(1));
    }
}