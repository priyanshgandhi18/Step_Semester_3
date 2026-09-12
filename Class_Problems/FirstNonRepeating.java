public class FirstNonRepeating {
    public static char findFirstNonRepeatingChar(String text) {
        int[] count = new int[256];
        for (char c : text.toCharArray()) count[c]++;
        for (char c : text.toCharArray()) {
            if (count[c] == 1) return c;
        }
        return '\0';
    }

    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc"};
        for (String text : inputs) {
            char result = findFirstNonRepeatingChar(text);
            if (result != '\0') {
                System.out.println("\"" + text + "\" | First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("\"" + text + "\" | No Non-Repeating Character Found");
            }
        }
    }
}