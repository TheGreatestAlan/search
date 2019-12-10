package nguyen.alan.interfaces;


import org.joda.time.DateTime;

public interface IQueryService {
    String[] find(String keyword, DateTime from, DateTime to, int offset, int number);
}
