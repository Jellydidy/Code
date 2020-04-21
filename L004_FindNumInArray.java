/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L004_FindNumInArray.java
 * @Description TODO
 * @createTime 2020年04月21日 23:49:00
 */
public class L004_FindNumInArray {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {

            int i = matrix.length-1, j=0;
            while (i >=0 && j <matrix[0].length) {
                if (matrix[i][j] < target) {
                    i--;
                } else if (matrix[i][j] > target) {
                    j++;
                } else {
                    return true;
                }
            }

            return false;
        }
    }
}
