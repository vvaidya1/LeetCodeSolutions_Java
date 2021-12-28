import java.util.*;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * O(k.log.k) time | O(k) space
 */
public class KthSmallestInASortedMatrix_PriorityQueue {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<MatrixElement> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        for (int i = 0; i < matrix.length; i++) queue.offer(new MatrixElement(0, i, matrix[0][i]));
        for (int j = 0; j < k - 1; j++) {
            MatrixElement me = queue.poll();

            if (me.i == matrix.length -1)
                continue;

            queue.offer(new MatrixElement(me.i + 1, me.j, matrix[me.i + 1][me.j]));
        }

        return queue.peek().value;
    }
}

class MatrixElement {
    int i, j;
    int value;

    public MatrixElement(int x, int y, int val) {
        i = x;
        j = y;
        value = val;
    }
}