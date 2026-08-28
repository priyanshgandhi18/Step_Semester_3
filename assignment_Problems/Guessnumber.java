import java.util.Scanner;

public class Level3_P5 {
    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tries = 0;
        boolean guessed = false;
        
        while (tries < maxTries && tries < guesses.length) {
            int currentGuess = guesses[tries];
            tries++;
            
            if (currentGuess == secretNumber) {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            } else if (currentGuess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Too high");
            }
        }
        
        if (!guessed) {
            System.out.println("Out of tries the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter secret number: ");
        int secretNumber = scanner.nextInt();

        System.out.print("Enter maximum allowed tries: ");
        int maxTries = scanner.nextInt();

        System.out.print("Enter number of guesses to test: ");
        int n = scanner.nextInt();
        int[] guesses = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter guess " + (i + 1) + ": ");
            guesses[i] = scanner.nextInt();
        }

        guessTheNumber(secretNumber, maxTries, guesses);

        scanner.close();
    }
}