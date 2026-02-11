public class Activity12 {
    public static void main(String[] args) {
        // Lambda expression without body (single expression)
        // This directly returns the sum of num1 and num2
        Addable ad1 = (num1, num2) -> num1 + num2;
        
        // Lambda expression with body (block of code)
        // This has curly braces and explicit return statement
        Addable ad2 = (num1, num2) -> {
            int sum = num1 + num2;
            return sum;
        };
        
        // Test both lambda expressions
        System.out.println("--- Testing Lambda Expressions ---");
        
        // Using ad1 (lambda without body)
        int result1 = ad1.add(10, 20);
        System.out.println("Result using ad1 (lambda without body): " + result1);
        
        // Using ad2 (lambda with body)
        int result2 = ad2.add(15, 25);
        System.out.println("Result using ad2 (lambda with body): " + result2);
        
        // More test cases
        System.out.println("\n--- More Examples ---");
        System.out.println("ad1.add(100, 200) = " + ad1.add(100, 200));
        System.out.println("ad2.add(50, 75) = " + ad2.add(50, 75));
    }
}
