class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < rowLength; i++){
            int rowMin = Integer.MAX_VALUE;
            int col = 0;
            for(int j = 0; j < colLength; j++){
                if(matrix[i][j] < rowMin){
                    rowMin = matrix[i][j];
                    col = j;
                }
            }
            boolean flag = false;
            for(int k = 0; k < rowLength; k++){
                if(matrix[k][col] > rowMin){
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }
            else{
                list.add(rowMin);
            }
        }
        return list;
    }
}