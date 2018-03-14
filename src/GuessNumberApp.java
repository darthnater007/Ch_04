import java.util.Scanner;

public class GuessNumberApp {
    
    public static void main(String[] args) {
        final int LIMIT = 100;

        System.out.println("Guess the god damn number!");
        System.out.println("I'm thinking of a fucking number from 1 to " + LIMIT);
        System.out.println();

        // get a random number between 1 and the limit
        double d = Math.random() * LIMIT; // d is >= 0.0 and < limit
        int number = (int) d;             // convert double to int
        number++;      
        int guess = 0;// int is >= 1 and <= limit
        int count = 0;

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);            
        while (guess != number) {
        	count++;
            System.out.print("Your guess: ");
            guess = sc.nextInt();
            
            if (guess < 1 || guess > LIMIT) 
            {
                System.out.println("Between 1 and 10, stupid.  Try again.");
                count--;
            }else if (guess < number) {
                System.out.println("Too low, dumbass.");
            } else if (guess > number) {
                System.out.println("Too high, shitbird.");
            }
        }
        System.out.println("You guessed it in " + 
                count + " tries.  Whoopty fucking doodah.\n");
        System.out.println("Bye now, ya prick!");
    }   
}