package geradorDeArquivos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Apod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeradorJson {

    public static <T> void salvarJson(T jsons) {
        LocalDate data = LocalDate.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String dataFormatada = data.format(formato);

        String nomeArquivo = null;

        if (jsons instanceof Apod) {
            try {
                String caminhoDiretorioApod = "C:\\Users\\Davi\\Documents\\GitHub\\nasaToday\\apod";

                File diretorio = new File(caminhoDiretorioApod);

                nomeArquivo = caminhoDiretorioApod + "\\" + dataFormatada + "-" + "apod.json";

                if (!(diretorio.exists())) {

                    boolean criacaoDiretorio = diretorio.mkdir();

                    if (criacaoDiretorio) {
                        System.out.println("Diretório criado com sucesso!");
                    }

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    FileWriter escrita = new FileWriter(nomeArquivo);
                    escrita.write(gson.toJson(jsons));
                    escrita.close();
                } else {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    FileWriter escrita = new FileWriter(nomeArquivo);
                    escrita.write(gson.toJson(jsons));
                    escrita.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
