public class Activity2 {
    public static void main(String[] args) {
        // Initialize an array with 6 numbers
        int[] numbers = {10, 77, 10, 54, -11, 10};
        
        // Variable to store the sum of 10's
        int sumOfTens = 0;
        
        // Find the 10's in the array and add them
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 10) {
                sumOfTens += numbers[i];
            }
        }
        
        // Check if value is equal to 30
        boolean result = (sumOfTens == 30);
        
        // Display the results
        System.out.println("Array elements: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Sum of all 10's: " + sumOfTens);
        System.out.println("Is sum equal to 30? " + result);
    }
}
