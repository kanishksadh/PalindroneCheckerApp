import java.util.*;
interface PalindromeStrategy {
    boolean check(String input);
}

// 2. Concrete Strategy A: Using a Stack (LIFO)
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : clean.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return clean.equals(reversed.toString());
    }
}

// 3. Concrete Strategy B: Using a Deque (Double-Ended Queue)
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// 4. Context Class: The Palindrome Checker
class PalindromeContext {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String text) {
        return strategy.check(text);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("--- UC12: Strategy Pattern Palindrome Checker ---");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.println("Choose Strategy: 1. Stack (LIFO)  2. Deque (Two-Way)");
        int choice = scanner.nextInt();

        // Polymorphism in action
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
            System.out.println("Using Stack Strategy...");
        } else {
            context.setStrategy(new DequeStrategy());
            System.out.println("Using Deque Strategy...");
        }

        if (context.validate(text)) {
            System.out.println("Result: It is a palindrome.");
        } else {
            System.out.println("Result: Not a palindrome.");
        }
        scanner.close();
    }
}