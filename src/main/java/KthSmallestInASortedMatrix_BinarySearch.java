
/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * O(k.log.k) time | O(k) space
 */
public class KthSmallestInASortedMatrix_BinarySearch {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessThanElements(matrix, mid);
            if (count < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return low;
    }

    int countLessThanElements(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1, count = 0;
        while ( i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            }
            else {
                count += (j + 1);
                i++;
            }
        }
        return count;
    }
}
