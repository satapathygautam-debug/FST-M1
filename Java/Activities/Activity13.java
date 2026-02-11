import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        // Create a Scanner object named scan
        Scanner scan = new Scanner(System.in);
        
        // Create an ArrayList object named list
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // Create a Random class object named indexGen
        Random indexGen = new Random();
        
        // Accept integer values from console
        System.out.println("Enter integers (enter a non-integer to stop):");
        
        // Use hasNextInt() to ensure only integer values are accepted
        while (scan.hasNextInt()) {
            int num = scan.nextInt();
            list.add(num);
        }
        
        // Check if list is empty
        if (list.isEmpty()) {
            System.out.println("No integers were entered.");
            scan.close();
            return;
        }
        
        // Convert ArrayList to array using toArray() method
        Integer nums[] = list.toArray(new Integer[0]);
        
        // Display all entered numbers
        System.out.println("\nNumbers entered: " + list);
        
        // Generate a random index value with bounds set to the length of nums array
        int randomIndex = indexGen.nextInt(nums.length);
        
        // Print the generated index value and the value at that index
        System.out.println("\nRandom index generated: " + randomIndex);
        System.out.println("Value at index " + randomIndex + ": " + nums[randomIndex]);
        
        // Close the scanner
        scan.close();
    }
}
