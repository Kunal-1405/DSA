import java.util.*;
class Solution {
    public boolean isThree(int n) {
        //only squares of prime numbers have 3 divisors
        int root=(int)Math.sqrt(n);
        if(root*root!=n){
            return false;
        }
        return isPrime(root);
    }
    public boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}