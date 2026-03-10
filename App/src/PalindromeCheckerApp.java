import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }
        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        // Clean string: remove non-alphanumeric and convert to lowercase
        String cleanStr = str.replaceAll("[^a-zA-Z0-String]", "").toLowerCase();
        if (cleanStr.length() <= 1) return true;

        // Step 1: Convert string to Singly Linked List
        Node head = convertToLinkedList(cleanStr);

        // Step 2: Find the middle using Fast and Slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse the second half of the list
        Node secondHalfHead = reverseList(slow);
        Node firstHalfHead = head;

        // Step 4: Compare the two halves
        Node tempSecond = secondHalfHead;
        boolean result = true;
        while (tempSecond != null) {
            if (firstHalfHead.data != tempSecond.data) {
                result = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            tempSecond = tempSecond.next;
        }

        // (Optional) Restore the list by reversing back if needed
        return result;
    }

    private static Node convertToLinkedList(String s) {
        Node dummy = new Node(' ');
        Node current = dummy;
        for (char c : s.toCharArray()) {
            current.next = new Node(c);
            current = current.next;
        }
        return dummy.next;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}