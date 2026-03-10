import java.util.Scanner;


public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Use Case 10: Case-Insensitive & Space-Ignored Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isNormalizedPalindrome(input)) {
            System.out.println("Result: It is a palindrome (ignoring case and spaces)!");
        } else {
            System.out.println("Result: It is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Normalizes the string and checks if it's a palindrome.
     * @param str The raw input string.
     * @return true if palindrome after normalization, false otherwise.
     */
    public static boolean isNormalizedPalindrome(String str) {
        if (str == null) return false;

        // Step 1: Normalization
        // [^a-zA-Z0-9] matches anything NOT a letter or number
        // .toLowerCase() ensures 'A' == 'a'
        String normalized = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Palindrome Logic (Two-Pointer)
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }

        return true; // Entire string matched
    }
}