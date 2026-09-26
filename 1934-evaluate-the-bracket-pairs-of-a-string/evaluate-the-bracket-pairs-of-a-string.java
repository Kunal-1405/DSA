class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = 0;

        // Step 2: Parse string s
        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                i++;
                int start = i;
                // Find the closing bracket
                while (i < n && s.charAt(i) != ')') {
                    i++;
                }
                String key = s.substring(start, i);
                result.append(map.getOrDefault(key, "?"));
            } else {
                result.append(c);
            }
            i++;
        }

        return result.toString();
    }
}