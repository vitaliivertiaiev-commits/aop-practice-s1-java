package homework.h05;

// LeetCode 1913: Maximum Product Difference Between Two Pairs
// https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
public class T1 {
    public int maxProductDifference(int[] nums) {
        if (nums == null || nums.length < 4) {
            throw new IllegalArgumentException("At least four numbers are required");
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : nums) {
            if (number <= smallest) {
                secondSmallest = smallest;
                smallest = number;
            } else if (number < secondSmallest) {
                secondSmallest = number;
            }

            if (number >= largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest) {
                secondLargest = number;
            }
        }

        return largest * secondLargest - smallest * secondSmallest;
    }
}
