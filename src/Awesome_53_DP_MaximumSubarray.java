public class Awesome_53_DP_MaximumSubarray {
    /*
    2020.01.19

    Given an integer array nums, find the contiguous subarray
    (containing at least one number)
    which has the largest sum and return its sum.

    [-2,1]
    [1,-3,4,-1]
    [4,-1,2,1]
    .......
    [-2,1,-3,4,-1,2,1,-5,4]
    Among all these combinations: [4,-1,2,1] has the largest sum = 6.
     */

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < length; i++) {
            int currentNum = nums[i];
            // todo 这个公式怎么处理？
            dp[i] = dp[i - 1] + currentNum > dp[i - 1] ? dp[i - 1] + currentNum : currentNum;
            if(dp[i] > maxSum) maxSum = dp[i];
        }
        return maxSum;
    }

}
