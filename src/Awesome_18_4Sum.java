import java.util.*;

public class Awesome_18_4Sum {
    /*

    2019.11.01

    similar to Q.15

    Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
    a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

    Note:

    The solution set must not contain duplicate quadruplets.

    Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

    A solution set is:
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]


     */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        int sum;

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 3; a++) {
            for (int b = a + 1; b < nums.length - 2; b++) {
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    int first = nums[a];
                    int second = nums[b];
                    int third = nums[c];
                    int fourth = nums[d];
                    sum = first + second + third + fourth;
                    if (sum - target == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(first);
                        temp.add(second);
                        temp.add(third);
                        temp.add(fourth);
                        set.add(temp);
                        // speed up the processing
                        while (c < d && nums[c] == nums[c + 1]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;
                        c++;
                        d--;
                    } else if (sum - target > 0) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
