public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        char[] rev = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return new String(arr).equals(new String(rev));
    }

    public static void main(String[] args) {
        String[] inputs = {"madam", "hello"};
        for (String text : inputs) {
            boolean iter = isPalindromeIterative(text);
            boolean rec = isPalindromeRecursive(text);
            boolean arrRev = isPalindromeArrayReversal(text);
            String status = (iter && rec && arrRev) ? "Palindrome" : "Not Palindrome";
            System.out.println("\"" + text + "\" | Iterative: " + (iter ? "Palindrome" : "Not Palindrome") + 
                               " | Recursive: " + (rec ? "Palindrome" : "Not Palindrome") + 
                               " | Array Reversal: " + (arrRev ? "Palindrome" : "Not Palindrome"));
        }
    }
}