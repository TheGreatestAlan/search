package nguyen.alan.rest.controller;

import nguyen.alan.factories.PersistorFactory;
import nguyen.alan.factories.QueryServiceFactory;
import nguyen.alan.interfaces.ISearchPersistor;
import nguyen.alan.interfaces.IQueryService;
import nguyen.alan.model.SearchDTO;
import nguyen.alan.model.SearchResultDTO;
import org.joda.time.DateTime;

import java.net.URISyntaxException;

import javax.validation.Validator;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/find")
@Produces(MediaType.APPLICATION_JSON)
public class FindController {

    private final Validator validator;
    private IQueryService queryService;
    private ISearchPersistor persistor;


    public FindController(Validator validator) {
        this.validator = validator;
        this.queryService = QueryServiceFactory.GetQueryService();
        this.persistor = PersistorFactory.GetPersistor();
    }

    @POST
    // Executes searches and returns results
    // Takes an entire SearchDTO object, or if search already exists just the
    // searchId
    public Response find(SearchDTO searchDTO) throws URISyntaxException {
        if(!SearchDTO.isValid(searchDTO))
        {
            return Response.status(Response.Status.BAD_REQUEST).entity("invalid date").build();
        }
        persistor.saveSearch(searchDTO);
        String[] results = queryService.find(
                searchDTO.getKeyword(),
                new DateTime(searchDTO.getFilters().getFrom()),
                new DateTime(searchDTO.getFilters().getTo()),
                searchDTO.getOffset(),
                searchDTO.getCount()
        );
        SearchResultDTO result = new SearchResultDTO(searchDTO,results.length,results);
        return Response.ok(result).build();
    }
}