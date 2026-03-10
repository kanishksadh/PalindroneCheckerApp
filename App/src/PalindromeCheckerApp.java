import java.util.*;


public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- UC13: Palindrome Algorithm Performance Comparison ---");
        System.out.print("Enter a long string for stress testing: ");
        String input = scanner.nextLine();

        // Normalize once to keep the test fair
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("\nBenchmarking Results:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s | %-15s | %-10s\n", "Algorithm", "Time (ns)", "Result");
        System.out.println("--------------------------------------------------");

        // 1. Benchmark Two-Pointer (Iterative)
        long start = System.nanoTime();
        boolean res1 = checkTwoPointer(cleanInput);
        long end = System.nanoTime();
        printRow("Two-Pointer", (end - start), res1);

        // 2. Benchmark Stack Strategy
        start = System.nanoTime();
        boolean res2 = checkStack(cleanInput);
        end = System.nanoTime();
        printRow("Stack (LIFO)", (end - start), res2);

        // 3. Benchmark Deque Strategy
        start = System.nanoTime();
        boolean res3 = checkDeque(cleanInput);
        end = System.nanoTime();
        printRow("Deque (Two-Way)", (end - start), res3);

        System.out.println("--------------------------------------------------");
        scanner.close();
    }

    private static void printRow(String name, long time, boolean result) {
        System.out.printf("%-20s | %-15d | %-10s\n", name, time, result ? "Pass" : "Fail");
    }

    // --- ALGORITHMS ---

    private static boolean checkTwoPointer(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    private static boolean checkStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    private static boolean checkDeque(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}