class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int rowstart = 0;
        int colend = c - 1;
        int rowend = r - 1;
        int colstart = 0;
        int d = 0;
        while (rowstart <= rowend && colstart <= colend) {
            if (d == 0) {
                for (int i = colstart; i <= colend; i++) {
                    ans.add(matrix[rowstart][i]);
                }
                rowstart++;
                d = 1;
            } else if (d == 1) {
                for (int i = rowstart; i <= rowend; i++) {
                    ans.add(matrix[i][colend]);

                }
                colend--;
                d = 2;
            } else if (d == 2) {
                for (int i = colend; i >= colstart; i--) {
                    ans.add(matrix[rowend][i]);
                }
                rowend--;
                d = 3;
            } else if (d == 3) {
                for (int i = rowend; i >= rowstart; i--) {
                    ans.add(matrix[i][colstart]);
                }
                colstart++;
                d = 0;
            }
        }
        return ans;
    }
}