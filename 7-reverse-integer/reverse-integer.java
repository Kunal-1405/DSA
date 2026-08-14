class Solution {
    public int reverse(int x) {
        int revnum=0;
        while(x!=0){
            int lastdigit=x%10;
            if(revnum > Integer.MAX_VALUE / 10 || revnum < Integer.MIN_VALUE / 10){
                return 0;
            }
            revnum=(revnum*10)+lastdigit;
            x=x/10;
        }
        return revnum;
    }
}