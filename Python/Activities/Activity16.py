# Car class definition

class Car:
    """
    A class to represent a car with various properties and methods.
    """
    
    def __init__(self, manufacturer, model, make, transmission, color):
        """
        Initialize a Car object with the given properties.
        
        Args:
            manufacturer: The manufacturer of the car (e.g., Toyota, Honda)
            model: The model name (e.g., Camry, Civic)
            make: The year the car was made
            transmission: Type of transmission (e.g., Automatic, Manual)
            color: The color of the car
        """
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
    
    def accelerate(self):
        """
        Print a message indicating the car is moving.
        """
        print(f"{self.manufacturer} {self.model} is moving")
    
    def stop(self):
        """
        Print a message indicating the car has stopped.
        """
        print(f"{self.manufacturer} {self.model} has stopped")
    
    def display_info(self):
        """
        Display all information about the car.
        """
        print(f"\n{'=' * 50}")
        print(f"Manufacturer: {self.manufacturer}")
        print(f"Model: {self.model}")
        print(f"Make (Year): {self.make}")
        print(f"Transmission: {self.transmission}")
        print(f"Color: {self.color}")
        print(f"{'=' * 50}")


# Main program
print("=" * 60)
print("CAR CLASS DEMONSTRATION")
print("=" * 60)

# Create 3 different car objects
print("\nCreating 3 different cars...\n")

# Car 1: Toyota Camry
car1 = Car(
    manufacturer="Toyota",
    model="Camry",
    make=2023,
    transmission="Automatic",
    color="Silver"
)

# Car 2: Honda Civic
car2 = Car(
    manufacturer="Honda",
    model="Civic",
    make=2022,
    transmission="Manual",
    color="Blue"
)

# Car 3: Tesla Model 3
car3 = Car(
    manufacturer="Tesla",
    model="Model 3",
    make=2024,
    transmission="Automatic",
    color="Red"
)

# Display information for each car
print("CAR 1:")
car1.display_info()

print("\nCAR 2:")
car2.display_info()

print("\nCAR 3:")
car3.display_info()

# Test the accelerate() and stop() methods
print("\n" + "=" * 60)
print("TESTING ACCELERATE AND STOP METHODS")
print("=" * 60)

print("\n--- Car 1 Actions ---")
car1.accelerate()
car1.stop()

print("\n--- Car 2 Actions ---")
car2.accelerate()
car2.stop()

print("\n--- Car 3 Actions ---")
car3.accelerate()
car3.stop()

# Simulate a journey
print("\n" + "=" * 60)
print("SIMULATING A JOURNEY")
print("=" * 60)

print("\nAll cars starting their journey...")
print("-" * 60)
car1.accelerate()
car2.accelerate()
car3.accelerate()

print("\nAll cars arriving at destination...")
print("-" * 60)
car1.stop()
car2.stop()
car3.stop()

print("\n" + "=" * 60)
print("DEMONSTRATION COMPLETE!")
print("=" * 60)
