// Main class with exception handling
public class Activity8 {
    
    // Method that throws CustomException if string is null
    public static void exceptionTest(String str) throws CustomException {
        if (str == null) {
            throw new CustomException("String value is null!");
        } else {
            System.out.println("String value: " + str);
        }
    }
    
    // Main method
    public static void main(String[] args) {
        // Test with a non-null string
        try {
            System.out.println("--- Test 1: Non-null string ---");
            exceptionTest("Hello, World!");
        } catch (CustomException e) {
            System.out.println("Custom Exception caught: " + e.getMessage());
        }
        
        System.out.println();
        
        // Test with a null string
        try {
            System.out.println("--- Test 2: Null string ---");
            exceptionTest(null);
        } catch (CustomException e) {
            System.out.println("Custom Exception caught: " + e.getMessage());
        }
    }
}
