import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Awesome_16_3SumClosest {
    /*
    2019.11.01

    o(n^2)
    o(1)

    similar to Q.15

    Given an array nums of n integers and an integer target,
    find three integers in nums such that the sum is closest to target.
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

    Given array nums = [-1, 2, 1, -4], and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    Translate:
    - pick 3 digits from input array
    - return the sum of 3 digits <- the sum is closest to target
     */

    public int threeSumClosest(int[] nums, int target) {
        //
        int anchor = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                int difference = sum - target;
                if (difference == 0) {
                    return sum;
                } else if (difference > 0) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(difference) < anchor) {
                    anchor = Math.abs(difference);
                    result = sum;
                }
            }
        }
        return result;
    }
}
