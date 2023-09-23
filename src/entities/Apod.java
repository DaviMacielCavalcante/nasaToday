package entities;

import com.google.gson.annotations.SerializedName;

public class Apod {

    @SerializedName("date")
    private String data;
    @SerializedName("title")
    private String titulo;
    @SerializedName("url")
    private String url;

    public Apod(ApodJson apod) {
        this.data = apod.date();
        this.titulo = apod.title();
        this.url = apod.url();
    }

    public String getData() {
        return data;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: " + data);
        sb.append("\n");
        sb.append("Titulo: " + titulo);
        sb.append("\n");
        sb.append("url: " + url);
        return sb.toString();
    }
}
