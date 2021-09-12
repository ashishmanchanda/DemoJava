package DS.Tree;
import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length-1;
        int maxCol = matrix[0].length-1;
        int total = (maxRow+1)*(maxCol+1);

        ArrayList<Integer> ans = new ArrayList<>();
        while(ans.size() < total){
            for(int i=minRow, j=minCol; j<=maxCol && ans.size() < total; j++){
                ans.add(matrix[i][j]);
            }
            minRow++;
            for(int i=minRow, j=maxCol; i<=maxRow && ans.size() < total; i++){
                ans.add(matrix[i][j]);
            }
            maxCol--;
            for(int i=maxRow, j=maxCol; j>=minCol && ans.size() < total; j--){
                ans.add(matrix[i][j]);
            }
            maxRow--;
            for(int i=maxRow, j=minCol; i>=minRow && ans.size() < total; i--){
                ans.add(matrix[i][j]);
            }
            minCol++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
