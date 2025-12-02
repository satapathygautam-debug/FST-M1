package Activities;

public class Activity2 {

    public static void main(String[] args) {

        int[] numbers = {10, 77, 10, 54, -11, 10 , 10 };

        int sum = 0;

        for (int i : numbers) {
            if (i == 10) {
                sum += 10;
            }
        }

        System.out.println("Sum of 10's: " + sum);

        if (sum == 30)
        {
            System.out.println("Value is equal to 30");
        } 
        else 
        {
            System.out.println("Value is NOT equal to 30");
        }
    }
}
