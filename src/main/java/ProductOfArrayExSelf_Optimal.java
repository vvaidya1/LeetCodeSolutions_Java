/*
 * https://leetcode.com/problems/product-of-array-except-self/
 * O(n) time | O(n) space
 */
public class ProductOfArrayExSelf_Optimal {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];

        product[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            product[i] = product[i-1] * nums[i-1];
        }

        int multiple = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            product[j] = product[j] * multiple;
            multiple *= nums[j];
        }

        return product;
    }
}
