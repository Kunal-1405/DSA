class Solution {
    public String reverseParentheses(String s) {
            int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Step 1: Map matching pairs of parentheses
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        // Step 2: Traverse using wormholes
        StringBuilder sb = new StringBuilder();
        int direction = 1; // 1 for moving right, -1 for moving left

        for (int i = 0; i < n; i += direction) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = pair[i];          // Teleport to the matching parenthesis
                direction = -direction; // Reverse direction
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}