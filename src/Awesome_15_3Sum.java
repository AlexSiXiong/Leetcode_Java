import java.util.*;

public class Awesome_15_3Sum {
    /*
    2019.10.31

    * Multi pointer
    * Math
    * Set

    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.

    The solution set must not contain duplicate triplets.

    Example:
    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
     */

    private static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> set = new HashSet<>();
        // important!
        // 如果不排序怎么做？
        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    set.add(temp);
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> test1 = new ArrayList<>();
        List<Integer> set1 = new ArrayList<>();
        set1.add(-1);
        set1.add(0);
        set1.add(1);
        List<Integer> set2 = new ArrayList<>();
        set1.add(-1);
        set1.add(-1);
        set1.add(2);
        test1.add(set1);
        test1.add(set2);

        List<List<Integer>> result = threeSum(input);
        // retainAll() -> check whether two Lists are equal
        System.out.println(result.retainAll(test1));

    }
}
