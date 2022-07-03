import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 * O(n.log.n) time | O(1) space - where n is the maximum of lengths of horizontal and vertical cuts
 */
public class MaximumAreaOfAPieceOfCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long mod = (long)1e9+7;

        long maxH = horizontalCuts[0], maxW = verticalCuts[0], prevH = 0, prevW = 0;
        for (int hCut : horizontalCuts) {
            maxH = Math.max(maxH, hCut - prevH);
            prevH = hCut;
        }
        maxH = Math.max(maxH, h - prevH);

        for (int vCut : verticalCuts) {
            maxW = Math.max(maxW, vCut - prevW);
            prevW = vCut;
        }
        maxW = Math.max(maxW, w - prevW);

        return (int)((maxH * maxW) % mod);
    }
}
