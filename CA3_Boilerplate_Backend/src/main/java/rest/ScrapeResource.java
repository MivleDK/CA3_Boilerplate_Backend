package rest;

import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import webscraper.TagCounter;
import webscraper.TagDTO;
import webscraper.Tester;

@Path("scrape")
public class ScrapeResource {

    @Context
    private UriInfo context;
    
    @Path("sequential")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTagsSequental() {
        long startTime = System.nanoTime();
        List<TagCounter> dataFetched = Tester.runSequental();
        long endTime = System.nanoTime() - startTime;
        return TagDTO.getTagsAsJson("Sequental fetching", dataFetched, endTime);
    }

    @Path("parallel")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTagsParrallel() throws NotImplementedException, InterruptedException, ExecutionException {
       long startTime = System.nanoTime();
        List<TagDTO> dataFetched = Tester.runParrallel();
        long endTime = System.nanoTime()-startTime;
        return TagDTO.getTagsAsJsonPara("Parralel fetching", dataFetched, endTime);
        //return "[Make me return results, fetched by a parrallel strategy";
    }
}