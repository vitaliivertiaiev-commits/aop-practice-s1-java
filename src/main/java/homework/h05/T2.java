package homework.h05;

// LeetCode 977: Squares of a Sorted Array
// https://leetcode.com/problems/squares-of-a-sorted-array/
public class T2 {
    public int[] sortedSquares(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("The input array must not be null");
        }

        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int index = nums.length - 1; index >= 0; index--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
        }

        return result;
    }
}
