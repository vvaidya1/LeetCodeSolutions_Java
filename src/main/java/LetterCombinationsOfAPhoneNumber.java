import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * O(4^n * n) time | O(4^n * n) space - where n is the length of the phone number
 */
public class LetterCombinationsOfAPhoneNumber {
    Map<Character, char[]> dict = new HashMap<>() {{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals(""))
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        helper(digits, 0, new StringBuilder(), result);
        return result;
    }

    void helper(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char num = digits.charAt(index);
        for (char ch : dict.get(num)) {
            current.append(ch);
            helper(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
