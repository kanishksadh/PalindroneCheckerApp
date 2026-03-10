import java.util.Scanner;
class PalindromeService {

    /**
     * Checks if a string is a palindrome.
     * @param input The raw string from the user.
     * @return true if palindrome, false otherwise.
     */
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        // Normalize the string within the service
        String cleanStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleanStr.length() - 1;

        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Instantiate the service object
        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter text to check: ");
        String userInput = scanner.nextLine();

        // Delegate the logic to the service object
        boolean isPalindrome = service.checkPalindrome(userInput);

        if (isPalindrome) {
            System.out.println("Result: Success! It is a palindrome.");
        } else {
            System.out.println("Result: Failure. Not a palindrome.");
        }

        scanner.close();
    }
}