package entities;

import java.io.Serializable;

public class Joke_Chuck implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String createdAt;
    private String url;
    private String value;

    public Joke_Chuck(String id, String createdAt, String url, String value) {
        this.id = id;
        this.createdAt = createdAt;
        this.url = url;
        this.value = value;
    }

    public Joke_Chuck() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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
}
