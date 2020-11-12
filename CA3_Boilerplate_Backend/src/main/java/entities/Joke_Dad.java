package entities;

import java.io.Serializable;

/**
 *
 * @author Per
 */
public class Joke_Dad implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String joke;
    private String status;

    public Joke_Dad(String id, String joke, String status) {
        this.id = id;
        this.joke = joke;
        this.status = status;
    }

    public Joke_Dad() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}