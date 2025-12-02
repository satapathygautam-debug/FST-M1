package Activities;

public class Car {
	
					String color;
					String transmission;
					int make;
					int tyres;
					int doors;
					
					public  Car()
					{
						//this.tyres = '4';
						this.doors = '4';
					}
					
                     public void displayCharacteristics() 
					
					{
						System.out.println("Your car Colour is " +color + "with transmission" +transmission +"of Makers" +make + ". No.of Tyres in car is" +tyres +" with Doors" +doors );
					}
					
					public void brake()
					
					{
					   System.out.println("Car has stopped");
					}
					
					
                    public void accelarate() 
					
					{
						System.out.println("Car is moving forward.");
					}
					
                 }

