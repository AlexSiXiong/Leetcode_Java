import java.util.HashMap;
import java.util.Map;

public class Awesome_1_TwoSum {
/*
    2019.10.14
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.


    Examples:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
 */


    // Enumeration
    private static int[] method1(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }

        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
    }

    // HashMap
    // Data Format

    //   key  : value
    // number : index

    private static int[] method2(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(target - nums[index])) {
                result[0] = map.get(target - nums[index]);
                result[1] = index;
            } else {
                map.put(nums[index], index);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] test1 = new int[] {2, 7, 11, 15};
        int target1 = 9;
        int[] result = method2(test1, target1);
        for(int i : result) {
            System.out.println(i);
        }

    }

}
