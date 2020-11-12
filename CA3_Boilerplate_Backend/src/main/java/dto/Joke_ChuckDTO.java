package dto;

import entities.Joke_Chuck;

public class Joke_ChuckDTO {

    private String url;
    private String value;
    private Joke_Chuck chuck;

    public Joke_ChuckDTO() {
    }

    public Joke_ChuckDTO(Joke_Chuck chuck) {
        this.url = chuck.getUrl();
        this.value = chuck.getValue();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Joke_Chuck getChuck() {
        return chuck;
    }

    public void setChuck(Joke_Chuck chuck) {
        this.chuck = chuck;
    }
}
