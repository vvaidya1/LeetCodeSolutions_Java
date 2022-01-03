import java.util.*;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * O(n) time | O(1) space - where n is the length of input string
 */
public class ValidParantheses {
    Deque<String> stack = new ArrayDeque<>();
    Map<String, String> parenthesesMap = new HashMap<>() {{
        put("(", ")");
        put("{", "}");
        put("[", "]");
    }};

    public boolean isValid(String s) {
        for (char ch : s.toCharArray()) {
            String str = String.valueOf(ch);
            if (isOpeningBracket(str))
                stack.push(str);
            else {
                String openingBracket = stack.size() > 0 ? stack.pop() : "";
                if(!str.equals(parenthesesMap.getOrDefault(openingBracket, "")))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    boolean isOpeningBracket(String s) {
        return s.equals("(") || s.equals("{") || s.equals("[");
    }
}
