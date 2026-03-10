import java.util.Scanner;


public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Use Case 9: Recursive Palindrome Checker ---");
        System.out.print("Enter a string to validate: ");
        String input = scanner.nextLine();

        // Clean the string (remove non-alphanumeric and lowercase)
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initial recursive call: start at 0 and end at length - 1
        if (isPalindromeRecursive(cleaned, 0, cleaned.length() - 1)) {
            System.out.println("Result: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursively checks whether a string is a palindrome.
     * @param str The cleaned input string.
     * @param start The starting index for comparison.
     * @param end The ending index for comparison.
     * @return true if matches continue to middle, false otherwise.
     */
    private static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base Case 1: If pointers cross or meet, all characters matched
        if (start >= end) {
            return true;
        }

        // Base Case 2: If characters at current positions don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Step: Shrink the problem by moving indices inward
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}