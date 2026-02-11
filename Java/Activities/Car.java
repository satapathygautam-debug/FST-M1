public class Car {
    // Instance variables
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    
    // Constructor to initialize tyres and doors
    public Car() {
        this.tyres = 4;
        this.doors = 4;
    }
    
    // Method to display all characteristics
    public void displayCharacteristics() {
        System.out.println("Car Characteristics:");
        System.out.println("Make: " + make);
        System.out.println("Color: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Tyres: " + tyres);
        System.out.println("Doors: " + doors);
    }
    
    // Method to simulate acceleration
    public void accelarate() {
        System.out.println("Car is moving forward.");
    }
    
    // Method to simulate braking
    public void brake() {
        System.out.println("Car has stopped.");
    }
}
