class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1; // 1 is always a proper divisor for num > 1
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i; // add the paired divisor
                }
            }
        }
        return sum == num;
    }
}