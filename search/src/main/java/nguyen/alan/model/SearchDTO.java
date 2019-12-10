package nguyen.alan.model;

import org.joda.time.DateTime;

public class SearchDTO {

    private int clientId;
    private String keyword;
    private Filters filters;
    private Integer searchId;
    private int count;
    private int offset;


    public SearchDTO()
    {}


    public SearchDTO(int clientId, String keyword, Filters filters, Integer searchId, int offset, int count)
    {
        this.clientId = clientId;
        this.keyword = keyword;
        this.filters = filters;
        this.searchId = searchId;
        this.offset = offset;
        this.count = count;
    }


    public SearchDTO(int clientId, String keyword, int offset, int count)
    {
        new SearchDTO(clientId, keyword, new Filters(), null, offset, count);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // looking up bean validation for dates specifically for hibernate validator was eating up too much time
    public static boolean isValid(SearchDTO search)
    {
        try
        {
            new DateTime(search.getFilters().getFrom());
            new DateTime(search.getFilters().getTo());
            return true;
        }
        catch(IllegalArgumentException e)
        {
            return false;
        }
    }

    public static class Filters
    {
        private String from;
        private String to;

        public Filters()
        {
        }

        public Filters(String from, String to)
        {
            this.from = from;
            this.to = to;
        }

        public String getFrom() {
            return from;

        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }
}
