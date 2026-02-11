import java.util.ArrayList;
import java.util.Date;

public class Plane {
    // Private variables - encapsulation
    private int maxPassengers;
    private ArrayList<String> passengers;
    private Date lastTimeLanded;
    private Date lastTimeTookOff;
    
    // Constructor to initialize maxPassengers and passengers array
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<String>();
    }
    
    // Method to onboard passengers
    public void onboard(String passenger) {
        this.passengers.add(passenger);
    }
    
    // Method for takeoff - returns current date and time
    public Date takeOff() {
        this.lastTimeTookOff = new Date();
        return lastTimeTookOff;
    }
    
    // Method for landing - sets lastTimeLanded and clears passengers
    public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
    
    // Getter method to return lastTimeLanded
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }
    
    // Getter method to return the list of passengers
    public ArrayList<String> getPassengers() {
        return passengers;
    }
}
