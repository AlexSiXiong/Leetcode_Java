import java.util.ArrayList;
import java.util.List;

public class Test {
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }

        bubble_sort(nums);
//        System.out.println("排序");
        int right = nums.length - 1;
        int left = right - 1;

        int sum_left = 0;
        int sum_right = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i <= left; i++) {
                sum_left += nums[i];
            }
//            System.out.println("sum_left " + sum_left);
            for (int i = nums.length - 1; i > left; i--) {
                sum_right += nums[i];
            }
//            System.out.println("sum_right " + sum_right);
            if (sum_right > sum_left) {
                break;
            }
            sum_left = 0;
            sum_right = 0;
            right--;
            left--;
        }
        for (int i = nums.length - 1; i > left; i--) {
            result.add(nums[i]);
        }
        return result;
    }

    public static void bubble_sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                int current;
                if (nums[j] > nums[j + 1]) {
                    current = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = current;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6};
//        bubble_sort(a);
//        for (int i : a) {
//            System.out.print(i + "   ");
//        }

        System.out.println(minSubsequence(a));
    }
}
