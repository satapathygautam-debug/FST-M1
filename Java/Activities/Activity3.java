public class Activity3 {
    public static void main(String[] args) {
        // Age in seconds
        long ageInSeconds = 1000000000L;
        
        // Earth orbital period in seconds
        final double EARTH_ORBITAL_PERIOD = 31557600.0;
        
        // Orbital periods in Earth years
        final double MERCURY_ORBITAL_PERIOD = 0.2408467;
        final double VENUS_ORBITAL_PERIOD = 0.61519726;
        final double MARS_ORBITAL_PERIOD = 1.8808158;
        final double JUPITER_ORBITAL_PERIOD = 11.862615;
        final double SATURN_ORBITAL_PERIOD = 29.447498;
        final double URANUS_ORBITAL_PERIOD = 84.016846;
        final double NEPTUNE_ORBITAL_PERIOD = 164.79132;
        
        // Calculate age on Earth in years
        double ageOnEarth = ageInSeconds / EARTH_ORBITAL_PERIOD;
        
        // Calculate age on other planets
        double ageOnMercury = ageOnEarth / MERCURY_ORBITAL_PERIOD;
        double ageOnVenus = ageOnEarth / VENUS_ORBITAL_PERIOD;
        double ageOnMars = ageOnEarth / MARS_ORBITAL_PERIOD;
        double ageOnJupiter = ageOnEarth / JUPITER_ORBITAL_PERIOD;
        double ageOnSaturn = ageOnEarth / SATURN_ORBITAL_PERIOD;
        double ageOnUranus = ageOnEarth / URANUS_ORBITAL_PERIOD;
        double ageOnNeptune = ageOnEarth / NEPTUNE_ORBITAL_PERIOD;
        
        // Display results
        System.out.println("Age in seconds: " + ageInSeconds);
        System.out.println("\nAge on different planets:");
        System.out.println("========================================");
        System.out.printf("Earth:   %.2f years%n", ageOnEarth);
        System.out.printf("Mercury: %.2f years%n", ageOnMercury);
        System.out.printf("Venus:   %.2f years%n", ageOnVenus);
        System.out.printf("Mars:    %.2f years%n", ageOnMars);
        System.out.printf("Jupiter: %.2f years%n", ageOnJupiter);
        System.out.printf("Saturn:  %.2f years%n", ageOnSaturn);
        System.out.printf("Uranus:  %.2f years%n", ageOnUranus);
        System.out.printf("Neptune: %.2f years%n", ageOnNeptune);
    }
}
