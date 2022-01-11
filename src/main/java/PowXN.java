/*
 * https://leetcode.com/problems/powx-n/
 * O(n) time | O(1) space
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        long nCopy = n;
        double result = 1.0;

        if (nCopy < 0) nCopy *= -1;
        while (nCopy > 0) {
            if (nCopy % 2 == 1) {
                result *= x;
                nCopy = nCopy - 1;
            }
            else {
                //Note below we're not assiging the result to final result but bumping up the magnitude of x
                x = x * x;
                nCopy = nCopy / 2;
            }
        }

        if (n < 0)
            result = (double) (1.0) / (double)result;

        return result;
    }
}
