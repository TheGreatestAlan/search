package nguyen.alan.factories;

import nguyen.alan.QueryService;
import nguyen.alan.interfaces.IQueryService;

// didn't want to take the time to setup Guice, it's been a while
public class QueryServiceFactory {

    public static IQueryService GetQueryService()
    {
        return new QueryService();
    }

}
