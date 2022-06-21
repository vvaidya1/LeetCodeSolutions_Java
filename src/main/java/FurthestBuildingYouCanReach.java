import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 * O(n.log.n) time | O(n) space - where n is the length of heights array
 */
public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length == 0)
            return -1;

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] <= heights[i - 1])
                continue;

            bricks -= heights[i] - heights[i - 1];
            maxHeap.offer(heights[i] - heights[i - 1]);
            if (bricks < 0) {
                bricks += maxHeap.poll();

                if (ladders > 0)
                    ladders--;
                else
                    return i - 1;
            }
        }
        return heights.length - 1;
    }
}
