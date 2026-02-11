// Derived class MountainBike extending Bicycle
public class MountainBike extends Bicycle {
    private int seatHeight;
    
    // Constructor using super keyword to initialize base class variables
    public MountainBike(int gears, int currentSpeed, int seatHeight) {
        super(gears, currentSpeed);
        this.seatHeight = seatHeight;
    }
    
    // Method to set new seat height
    public void setHeight(int newHeight) {
        seatHeight = newHeight;
        System.out.println("Seat height set to: " + seatHeight + " inches");
    }
    
    // Overriding bicycleDesc() to include seat height
    @Override
    public void bicycleDesc() {
        super.bicycleDesc();  // Call parent class method
        System.out.println("Seat height: " + seatHeight + " inches");
    }
}
