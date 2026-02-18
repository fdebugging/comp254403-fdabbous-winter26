import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true; // base case
        }

        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = input.nextLine();

        if (isPalindrome(userInput)) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("It is not a palindrome.");
        }

        input.close();
    }
}
