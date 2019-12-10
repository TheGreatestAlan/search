package nguyen.alan;

import nguyen.alan.exceptions.MissingIdException;
import nguyen.alan.interfaces.ISearchPersistor;
import nguyen.alan.model.Search;
import nguyen.alan.model.SearchDTO;
import org.joda.time.DateTime;

// I've set this up to be have methods that interface with a standard relational database
public class SearchPersistor implements ISearchPersistor {
    public SearchPersistor()
    {}

    @Override
    public void saveSearch(SearchDTO search) {
        Search existingSearch = findSearch(search);
        if(existingSearch == null)
        {
            createSearch(search);
        }
    }

    public SearchDTO[] getSearch(int clientId, String keyword) {
        // select * from Search where clientId = $clientId and keyword = $keyword
        return new SearchDTO[0];
    }

    public SearchDTO[] getClientSearches(int clientId)
    {
        // select *
        // from Search s
        // where s.SearchId = $clientId
        // then map from Search to SearchDTO

        return new SearchDTO[]{};
    }

    public void deleteSearch(SearchDTO[] searches) throws MissingIdException
    {
        for(SearchDTO search : searches)
        {
            if(search.getSearchId() == null)
            {
                throw new MissingIdException("Missing Id");
            }
        }
    }

    private Search findSearch(SearchDTO search)
    {
        // maps between SearchDTO and Search, runs query to DB
        return new Search();
    }

    private void addDateTimeToSearch(Search search)
    {
        addDateTimeToSearch(search, DateTime.now());
    }

    private void addDateTimeToSearch(Search search, DateTime dateTime)
    {
        // insert into SearchFilters set SearchId = $search.SearchId, DateTime = $datetime
    }

    private int createSearch(SearchDTO search)
    {
        return 0;
    }

}
