public class Activity4 {
    public static void main(String[] args) {
        // Initialize an array with numbers in random order
        int[] numbers = {64, 34, 25, 12, 22, 11, 90, 88, 45, 50};
        
        // Display the array before sorting
        System.out.println("Array before sorting:");
        displayArray(numbers);
        
        // Apply insertion sort
        insertionSort(numbers);
        
        // Display the array after sorting
        System.out.println("\nArray after sorting:");
        displayArray(numbers);
    }
    
    // Method to implement insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        // Start from the second element (index 1)
        // The first element (index 0) is considered already sorted
        for (int i = 1; i < n; i++) {
            // Select the unsorted card (key)
            int key = arr[i];
            int j = i - 1;
            
            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            
            // Place the key at its correct position
            arr[j + 1] = key;
        }
    }
    
    // Method to display the array
    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
