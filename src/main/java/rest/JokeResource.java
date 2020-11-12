package rest;

import com.google.gson.Gson;
import dto.Joke_ChuckDTO;
import dto.Joke_DadDTO;
import dto.Joke_CombinedDTO;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utils.HttpUtils;

@Path("jokes")
public class JokeResource {

    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() throws IOException {
        Gson gson = new Gson();
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        Joke_ChuckDTO chuckDTO = gson.fromJson(chuck, Joke_ChuckDTO.class);

        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        Joke_DadDTO dadDTO = gson.fromJson(dad, Joke_DadDTO.class);

        Joke_CombinedDTO combinedDTO = new Joke_CombinedDTO(chuckDTO, dadDTO);

        String combinedJSON = gson.toJson(combinedDTO);
        return combinedJSON;
    }
}
