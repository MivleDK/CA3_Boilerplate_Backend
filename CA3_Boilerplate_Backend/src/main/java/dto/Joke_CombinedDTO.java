/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Per
 */
public class Joke_CombinedDTO {
    
    private String joke1;
    private String joke1Reference;
    private String joke2;
    private String joke2Reference;

    public Joke_CombinedDTO(Joke_ChuckDTO chuckDTO, Joke_DadDTO dadDTO) {
        this.joke1 = chuckDTO.getValue();
        this.joke1Reference = chuckDTO.getUrl();
        this.joke2 = dadDTO.getJoke();
        this.joke2Reference = dadDTO.getUrl();
    }

    public Joke_CombinedDTO() {
    }

    public String getJoke1() {
        return joke1;
    }

    public void setJoke1(String joke1) {
        this.joke1 = joke1;
    }

    public String getJoke1Reference() {
        return joke1Reference;
    }

    public void setJoke1Reference(String joke1Reference) {
        this.joke1Reference = joke1Reference;
    }

    public String getJoke2() {
        return joke2;
    }

    public void setJoke2(String joke2) {
        this.joke2 = joke2;
    }

    public String getJoke2Reference() {
        return joke2Reference;
    }

    public void setJoke2Reference(String joke2Reference) {
        this.joke2Reference = joke2Reference;
    }
    
    
}
