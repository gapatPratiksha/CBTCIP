
import java.util.Scanner;
import java.util.Random;
    public class Main2 {
        public static void main(String[] args) {
            Random random = new Random();
            int ranNum = random.nextInt(100);
            int attempts = 0;
            final int maxAttempts = 3;
            boolean gameOver = false;

            System.out.println(ranNum);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Guess the number between 0 and 99");

            while (!gameOver && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userNum = scanner.nextInt();
                attempts++;

                if (userNum > ranNum) {
                    System.out.println("Your guess is greater than the random number. Attempts left: " + (maxAttempts - attempts));
                } else if (userNum < ranNum) {
                    System.out.println("Your guess is less than the random number. Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    gameOver = true;
                }

                if (attempts >= maxAttempts && userNum != ranNum) {
                    System.out.println("Sorry, you've used all your attempts! The number was: " + ranNum);
                    gameOver = true;
                }
            }


        }
    }
