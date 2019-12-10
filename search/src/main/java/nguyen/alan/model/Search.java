package nguyen.alan.model;

import org.joda.time.DateTime;

//DB Table
public class Search {

    //pk
    private int searchId;

    private String keyword;

    //fk - Client
    private int clientId;

    private DateTime from;

    private DateTime to;

    private int offset;
}
