package com.rohit.dsa;

public class MinLengthSubarrayWhereSumGreaterOrEqualToTargetSlidingWindow {

    public static void main(String [] args) {
        int[] nums = {2,3,1,2,4,3};

        int minLength = getMinLength(nums,6);
        System.out.println("Min Length -> " + minLength);
    }

    // Time Complexity - O(n) even after having nested while loop as it's gonna run a few times only
    public static int getMinLength(int [] nums, int target) {
        int minLen = Integer.MAX_VALUE;

        int sum = 0;

        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            sum += nums[rightPointer];
            while (sum >= target) {
                minLen = Math.min(minLen, rightPointer - leftPointer + 1);
                sum -= nums[leftPointer];
                leftPointer++;
            }
        }

        return minLen;
    }
}
