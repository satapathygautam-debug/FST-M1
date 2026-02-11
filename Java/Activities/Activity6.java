import java.util.Date;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        // Create an object of Plane class with maxPassengers set to 10
        Plane plane = new Plane(10);
        
        // Add passengers to the plane using onboard method
        plane.onboard("John");
        plane.onboard("Sarah");
        plane.onboard("Mike");
        plane.onboard("Emma");
        plane.onboard("David");
        
        // Print the take-off time
        Date takeOffTime = plane.takeOff();
        System.out.println("Plane took off at: " + takeOffTime);
        
        // Print the list of passengers
        System.out.println("\nList of passengers:");
        System.out.println(plane.getPassengers());
        
        // Pause execution for 5 seconds to emulate plane in flight
        System.out.println("\nPlane is in flight...");
        Thread.sleep(5000);
        
        // Land the plane
        plane.land();
        
        // Print the landing time
        System.out.println("\nPlane landed at: " + plane.getLastTimeLanded());
        
        // Print passengers after landing (should be empty)
        System.out.println("Passengers after landing: " + plane.getPassengers());
    }
}
