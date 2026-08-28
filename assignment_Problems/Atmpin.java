import java.util.Scanner;

public class Atmpin {
    public static void atmPinRetry(String correctPin, String[] attempts) {
        int attemptCount = 0;
        boolean isSuccess = false;
        
        while (attemptCount < attempts.length && attemptCount < 3 && !isSuccess) {
            if (attempts[attemptCount].equals(correctPin)) {
                isSuccess = true;
                System.out.println("PIN accepted");
                break;
            }
            attemptCount++;
        }
        
        if (!isSuccess) {
            System.out.println("Card blocked too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Set correct PIN: ");
        String correctPin = scanner.next();
        
        System.out.print("Enter number of attempts to test (up to 3): ");
        int n = scanner.nextInt();
        String[] attempts = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter attempt " + (i + 1) + ": ");
            attempts[i] = scanner.next();
        }
        
        atmPinRetry(correctPin, attempts);
        
        scanner.close();
    }
}