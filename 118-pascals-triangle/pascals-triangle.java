class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascaltriangle = new ArrayList<>();
        for(int row = 1; row <= numRows; row++){
            pascaltriangle.add(ansrow(row));
        }
        return pascaltriangle;
    }
    private List<Integer> ansrow(int row){
        int ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col = 1; col < row; col++ ){
            ans *= (row - col);
            ans /= col;
            ansRow.add(ans);
        }
        return ansRow;

    }
}