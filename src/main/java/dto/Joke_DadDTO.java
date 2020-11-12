package dto;

import entities.Joke_Dad;

public class Joke_DadDTO {

    private String joke;
    private String url = "https://icanhazdadjoke.com";

    public Joke_DadDTO(Joke_Dad dad, String url) {
        this.joke = dad.getJoke();
        this.url = url;
    }

    public Joke_DadDTO() {
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
