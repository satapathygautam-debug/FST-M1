// Driver class with main method
public class Activity7 {
    public static void main(String[] args) {
        // Create an object of MountainBike class
        MountainBike mountainBike = new MountainBike(5, 0, 20);
        
        // Display bicycle description
        mountainBike.bicycleDesc();
        
        // Use speedUp method to increase speed
        System.out.println("\n--- Riding the Mountain Bike ---");
        mountainBike.speedUp(10);
        mountainBike.speedUp(5);
        
        // Use applyBrake method to decrease speed
        mountainBike.applyBrake(3);
        
        // Change seat height
        System.out.println();
        mountainBike.setHeight(25);
        
        // Display updated description
        System.out.println();
        mountainBike.bicycleDesc();
    }
}
