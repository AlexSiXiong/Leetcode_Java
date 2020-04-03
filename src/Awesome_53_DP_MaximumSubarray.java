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

    2020.04.03

    30 days challenge

    day 3

    I think I tried this problem long time ago, maybe oen year ago.
    and I used a non-DP solution, as I am using this time.

    Honestly, I have not mastered DP yet.
    I am about to review it this time.
     */

//    没看懂...
//    这是第一次写的

//    public int maxSubArray(int[] nums) {
//        int length = nums.length;
//        int[] dp = new int[length];
//        dp[0] = nums[0];
//        int maxSum = dp[0];
//        for (int i = 1; i < length; i++) {
//            int currentNum = nums[i];
//            // todo 这个公式怎么处理？
//            dp[i] = dp[i - 1] + currentNum > dp[i - 1] ? dp[i - 1] + currentNum : currentNum;
//            if(dp[i] > maxSum) maxSum = dp[i];
//        }
//        return maxSum;
//    }

    private static int method2(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            max = Math.max(sum , max);
        }

        return max;
    }

    private static int method3(int[] nums) {
        // method2 level up
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max += nums[i];
            }

            max = Math.max(max, nums[i]);
        }
        return max;
    }

    private static int method4(int[] nums) {
        // DP.1
        // 以数组 {1,2,3,4} 为例

        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        for (int len = 1; len <= n; len++) {
            // 元素的个数，一共四个
            System.out.println();
            for (int i = 0; i <= n - len; i++) {
                //直接覆盖掉前边对应的情况就行

//                System.out.println("第一个 "+dp[i]);
                dp[i] = dp[i] + nums[i + (len - 1)]; // 这个地方（len - 1） 是为了和数组0为起点对应，所以要减去一个1
//                System.out.println("第二个 "+dp[i]);
                //更新 max
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] temp = {1,2,-3,4};
        System.out.println(method4(temp));
    }

}
