class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            char head = s.charAt(left);
            char tail = s.charAt(right);
            
            // 1. Fast-forward through non-alphanumeric characters in a loop
            if (!Character.isLetterOrDigit(head)) {
                left++;
            } else if (!Character.isLetterOrDigit(tail)) {
                right--;
            } else {
                // 2. Compare characters ignoring case directly without s.toLowerCase()
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        
        return true;
    }
}