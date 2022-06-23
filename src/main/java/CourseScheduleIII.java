import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule-iii/
 * O(n.log.n) time | O(n) space - where n is the length of input array
 */
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0)
            return 0;

        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));

        int result = 0, totalDuration = 0;
        for (int[] c : courses) {
            if (totalDuration + c[0] <= c[1]) {
                totalDuration += c[0];
                queue.offer(c[0]);
            }
            else if (!queue.isEmpty() && queue.peek() > c[0]) {
                totalDuration += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }
}
