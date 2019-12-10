package nguyen.alan.model;

public class SearchResultDTO {
    private SearchDTO search;
    private int totalResults;
    private String[] text;

    public SearchResultDTO(SearchDTO search, int totalResults, String[] text) {
        this.search = search;
        this.totalResults = totalResults;
        this.text = text;
    }

    public SearchDTO getSearch() {
        return search;
    }

    public void setSearch(SearchDTO search) {
        this.search = search;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }
}
