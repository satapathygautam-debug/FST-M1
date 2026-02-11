// Custom Exception class
public class CustomException extends Exception {
    // Private variable for custom exception message
    private String message;
    
    // Constructor to initialize the custom message
    public CustomException(String message) {
        this.message = message;
    }
    
    // Override getMessage() to return the custom message
    @Override
    public String getMessage() {
        return message;
    }
}
