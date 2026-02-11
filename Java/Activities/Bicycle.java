// Base class Bicycle implementing both interfaces
public class Bicycle implements BicycleParts, BicycleOperations {
    protected int gears;
    protected int currentSpeed;
    
    // Constructor to initialize gears and currentSpeed
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }
    
    // Implementation of applyBrake() - reduces speed
    @Override
    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        System.out.println("Brake applied. Current speed: " + currentSpeed);
    }
    
    // Implementation of speedUp() - increases speed
    @Override
    public void speedUp(int increment) {
        currentSpeed += increment;
        System.out.println("Speed increased. Current speed: " + currentSpeed);
    }
    
    // Method to describe the bicycle
    public void bicycleDesc() {
        System.out.println("\nBicycle Description:");
        System.out.println("Number of gears: " + gears);
        System.out.println("Max speed: " + maxSpeed + " mph");
        System.out.println("Number of tyres: " + tyres);
    }
}
