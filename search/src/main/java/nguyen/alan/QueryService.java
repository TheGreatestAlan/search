package nguyen.alan;

import nguyen.alan.interfaces.IQueryService;
import org.joda.time.DateTime;

// this will be implemented to interface with whatever query service we're using
public class QueryService implements IQueryService {

    @Override
    public String[] find(String keyword, DateTime from, DateTime to, int offset, int number) {
        return new String[]{"SEARCH RESPONSE"};
    }
}
