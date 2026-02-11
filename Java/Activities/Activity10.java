import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        // Create a HashSet named hs
        HashSet<String> hs = new HashSet<String>();
        
        // Add 6 objects using add() method to the HashSet
        System.out.println("--- Adding Elements ---");
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Cherry");
        hs.add("Date");
        hs.add("Elderberry");
        hs.add("Fig");
        
        System.out.println("Elements added to HashSet: " + hs);
        
        // Print the size of the HashSet using the size() method
        System.out.println("\n--- Size of HashSet ---");
        System.out.println("Size of HashSet: " + hs.size());
        
        // Remove an element using the remove() method
        System.out.println("\n--- Removing Elements ---");
        boolean removed1 = hs.remove("Banana");
        System.out.println("Removed 'Banana': " + removed1);
        
        // Try to remove an element that is not present in the Set
        boolean removed2 = hs.remove("Grape");
        System.out.println("Removed 'Grape' (not in set): " + removed2);
        
        // Use the contains() method to check if an item is in the Set or not
        System.out.println("\n--- Contains Method ---");
        String searchItem1 = "Cherry";
        String searchItem2 = "Banana";
        
        if (hs.contains(searchItem1)) {
            System.out.println(searchItem1 + " is present in the HashSet.");
        } else {
            System.out.println(searchItem1 + " is not present in the HashSet.");
        }
        
        if (hs.contains(searchItem2)) {
            System.out.println(searchItem2 + " is present in the HashSet.");
        } else {
            System.out.println(searchItem2 + " is not present in the HashSet.");
        }
        
        // Print the updated set
        System.out.println("\n--- Updated HashSet ---");
        System.out.println("Updated HashSet: " + hs);
        System.out.println("Updated size: " + hs.size());
        
        // Bonus: Check if HashSet is empty using isEmpty() method
        System.out.println("\n--- Is Empty Check ---");
        System.out.println("Is HashSet empty? " + hs.isEmpty());
    }
}
