import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, sb, result);
        return result;
    }

    private void backtrack(int n, StringBuilder sb, List<String> result) {
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }

        // Always valid to append '1'
        sb.append('1');
        backtrack(n, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        // Can only append '0' if the string is empty or the previous character is '1'
        if (sb.length() == 0 || sb.charAt(sb.length() - 1) == '1') {
            sb.append('0');
            backtrack(n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}