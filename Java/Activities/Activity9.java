import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        // Create an ArrayList named myList of type String
        ArrayList<String> myList = new ArrayList<String>();
        
        // Add 5 names to the ArrayList using add() method
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("Diana");
        myList.add("Edward");
        
        System.out.println("--- Original List ---");
        // Print all the names using for loop
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        
        // Use get() method to retrieve the 3rd name in the ArrayList
        System.out.println("\n--- Get 3rd Name ---");
        String thirdName = myList.get(2);  // Index 2 is the 3rd element
        System.out.println("The 3rd name is: " + thirdName);
        
        // Use contains() method to check if a name exists in the ArrayList
        System.out.println("\n--- Contains Method ---");
        String searchName1 = "Diana";
        String searchName2 = "Frank";
        
        if (myList.contains(searchName1)) {
            System.out.println(searchName1 + " exists in the list.");
        } else {
            System.out.println(searchName1 + " does not exist in the list.");
        }
        
        if (myList.contains(searchName2)) {
            System.out.println(searchName2 + " exists in the list.");
        } else {
            System.out.println(searchName2 + " does not exist in the list.");
        }
        
        // Use size() method to print the number of names in the ArrayList
        System.out.println("\n--- Size of List ---");
        System.out.println("Number of names in the list: " + myList.size());
        
        // Use remove() method to remove a name from the list
        System.out.println("\n--- Remove a Name ---");
        String removedName = myList.remove(1);  // Remove Bob (index 1)
        System.out.println("Removed: " + removedName);
        
        // Print the size() of the list again
        System.out.println("Number of names after removal: " + myList.size());
        
        // Display the updated list
        System.out.println("\n--- Updated List ---");
        for (String name : myList) {
            System.out.println(name);
        }
    }
}
