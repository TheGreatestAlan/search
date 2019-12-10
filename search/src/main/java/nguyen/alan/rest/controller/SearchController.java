package nguyen.alan.rest.controller;

import nguyen.alan.exceptions.MissingIdException;
import nguyen.alan.factories.PersistorFactory;
import nguyen.alan.interfaces.ISearchPersistor;
import nguyen.alan.model.SearchDTO;

import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchController {

    private final Validator validator;
    private ISearchPersistor persistor;

    public SearchController(Validator validator) {
        this.validator = validator;
        this.persistor = PersistorFactory.GetPersistor();
    }

    @GET
    @Path("/{clientid}")
    public Response getSearchByClientId(@PathParam("clientid") Integer clientId) {
        return Response.ok(persistor.getClientSearches(clientId)).build();
    }

    @GET
    @Path("/{clientid}/{keyword}")
    public Response getSearchByKeyword(@PathParam("clientId") Integer clientId, @PathParam("keyword") String keyword) {
        SearchDTO[] searches = persistor.getSearch(clientId, keyword);
        return Response.ok(searches).build();
    }

    // requires searchIds
    @DELETE
    public Response removeSearch(SearchDTO[] searches)
    {
        for(SearchDTO search : searches)
        {
            if(!SearchDTO.isValid(search))
            {
                return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Date").build();
            }
        }
        try
        {
            persistor.deleteSearch(searches);
            return Response.noContent().build();
        }
        catch(MissingIdException e)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity("Missing search id").build();
        }
    }
}
