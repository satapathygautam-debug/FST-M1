import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        // Create a Map named colours with integer keys and String values
        Map<Integer, String> colours = new HashMap<Integer, String>();
        
        // Add 5 random colours to it
        System.out.println("--- Adding Colours ---");
        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
        colours.put(4, "Yellow");
        colours.put(5, "Purple");
        
        // Print the Map to the console
        System.out.println("Original Map: " + colours);
        
        // Remove one colour using the remove() method
        System.out.println("\n--- Removing a Colour ---");
        String removedColour = colours.remove(2);
        System.out.println("Removed colour with key 2: " + removedColour);
        
        // Check if the colour green exists in the Map using the containsValue() method
        System.out.println("\n--- Contains Value Check ---");
        String searchColour = "Green";
        if (colours.containsValue(searchColour)) {
            System.out.println(searchColour + " exists in the Map.");
        } else {
            System.out.println(searchColour + " does not exist in the Map.");
        }
        
        // Check for a colour that was removed
        String searchColour2 = "Blue";
        if (colours.containsValue(searchColour2)) {
            System.out.println(searchColour2 + " exists in the Map.");
        } else {
            System.out.println(searchColour2 + " does not exist in the Map.");
        }
        
        // Print the size of the Map using the size() method
        System.out.println("\n--- Size of Map ---");
        System.out.println("Size of the Map: " + colours.size());
        
        // Print the updated Map
        System.out.println("\n--- Updated Map ---");
        System.out.println("Updated Map: " + colours);
    }
}
