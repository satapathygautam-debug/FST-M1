public class Activity1 {
    public static void main(String[] args) {
        // Create an object of the Car class
        Car myCar = new Car();
        
        // Initialize the values
        myCar.make = 2014;
        myCar.color = "Black";
        myCar.transmission = "Manual";
        
        // Call the methods
        myCar.displayCharacteristics();
        System.out.println(); // Empty line for better readability
        myCar.accelarate();
        myCar.brake();
    }
}
