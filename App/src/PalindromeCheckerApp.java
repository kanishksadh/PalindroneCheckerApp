import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to Palindrome Checker App Management System");


        // Hardcoded input string
        String input = "noon";

        // Create Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character into stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Pop and compare
        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        System.out.println("Input : " + input);
        if (isPalindrome) {
            System.out.println("Is Palindrome? : true");
        } else {
            System.out.println("Is Palindrome? : false");
        }

    }
}