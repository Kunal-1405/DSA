class Solution {
    private int index = 0;
    public List<String> braceExpansionII(String expression) {
        this.index = 0;
        Set<String> set = parseExpr(expression);
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
    private Set<String> parseExpr(String s) {
        Set<String> res = new HashSet<>();  // Stores union of terms separated by ','
        Set<String> cur = new HashSet<>();  // Stores current concatenated group
        cur.add("");

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (ch == '{') {
                index++; // Skip '{'
                Set<String> nextSet = parseExpr(s);
                cur = concat(cur, nextSet);
            } else if (ch == '}') {
                index++; // Skip '}'
                break;   // Return to outer call
            } else if (ch == ',') {
                index++; // Skip ','
                res.addAll(cur);
                cur = new HashSet<>();
                cur.add("");
            } else {
                // Lowercase letter
                Set<String> nextSet = new HashSet<>();
                nextSet.add(String.valueOf(ch));
                cur = concat(cur, nextSet);
                index++;
            }
        }
        res.addAll(cur);
        return res;
    }

    private Set<String> concat(Set<String> set1, Set<String> set2) {
        Set<String> res = new HashSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                res.add(s1 + s2);
            }
        }
        return res;
    }
}