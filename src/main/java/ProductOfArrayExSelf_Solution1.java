
/*
 * https://leetcode.com/problems/product-of-array-except-self/
 * O(n) time | O(n) space
 */
public class ProductOfArrayExSelf_Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] result = new int[nums.length];

        leftProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        rightProduct[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            rightProduct[j] = rightProduct[j+1] * nums[j+1];
        }

        for (int k = 0; k < nums.length; k++) {
            result[k] = leftProduct[k] * rightProduct[k];
        }

        return result;
    }
}
