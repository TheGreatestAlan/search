package nguyen.alan.exceptions;

public class MissingIdException extends Exception{
    public MissingIdException(String errorMessage){
        super(errorMessage);
    }
}
