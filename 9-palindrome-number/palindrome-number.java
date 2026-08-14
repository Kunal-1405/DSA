class Solution {
    public boolean isPalindrome(int x) {
        int original=x;
        int revnum=0;
        if(x<0){
            return false;
        }
        while(x!=0){
            int lastdigit=x%10;
            if(revnum > Integer.MAX_VALUE / 10){
                return false;
            }
            revnum=(revnum*10)+lastdigit;
            x/=10;
        }
        return(original==revnum);
    }
}