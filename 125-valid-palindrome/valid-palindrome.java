class Solution {
    public boolean isPalindrome(String s) {
        return palindrome(s.toLowerCase(),0,s.length()-1);
    }
    public static boolean palindrome(String str, int left, int right){
        if(left>=right){   //base case 
            return true;
        }
        if (!Character.isLetterOrDigit(str.charAt(left))) {   // Skip non-alphanumeric characters from the left
            return palindrome(str, left + 1, right);
        }
        if (!Character.isLetterOrDigit(str.charAt(right))) {  //Skip non-alphanumeric characters from the right
            return palindrome(str, left, right - 1);
        }
        if(str.charAt(left)!=str.charAt(right)){  // Check if characters at the current positions are the same
            return false;
        }
        return palindrome(str,left+1,right-1);
    }
}