class Solution {
    public void reverse(int[] row, int low, int high){
        while(low < high){
            int temp = row[low];
            row[low] = row[high];
            row[high] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i <= n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
        }
        }

        for(var row : matrix){
            reverse(row, 0, row.length - 1);
        }
    }
}
