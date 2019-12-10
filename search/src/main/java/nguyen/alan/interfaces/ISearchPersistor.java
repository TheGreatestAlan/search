package nguyen.alan.interfaces;

import nguyen.alan.exceptions.MissingIdException;
import nguyen.alan.model.SearchDTO;

public interface ISearchPersistor {
    void saveSearch(SearchDTO search);
    SearchDTO[] getSearch(int clientId, String keyword);
    SearchDTO[] getClientSearches(int clientId);
    void deleteSearch(SearchDTO[] searches) throws MissingIdException;
}
