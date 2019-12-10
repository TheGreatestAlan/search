package nguyen.alan.factories;

import nguyen.alan.SearchPersistor;
import nguyen.alan.interfaces.ISearchPersistor;

// didn't want to take the time to setup Guice, it's been a while
public class PersistorFactory {

    public static ISearchPersistor GetPersistor()
    {
        return new SearchPersistor();
    }

}
