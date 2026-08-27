class Solution {
    public List<Integer> getRow(int rowIndex) {
        return(ansRow(rowIndex));
    }
    private List<Integer> ansRow(int row){
        long ans = 1;
        List<Integer> r = new ArrayList<>();
        r.add(1);
        for(int col = 1; col <= row; col++){
            ans *= (row-col+1);
            ans /= col;
            r.add((int)ans);
        }
        return r;
    }
}