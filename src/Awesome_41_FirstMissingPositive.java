public class Awesome_41_FirstMissingPositive {
    /*
    Given an unsorted integer array, find the smallest missing positive integer.

    Example:
    Input: [1,2,0]
    Output: 3

    Input: [3,4,-1,1]
    Output: 2

    Input: [7,8,9,11,12]
    Output: 1


     */

    public static int[] method1(int[] nums) {
        // 1. sort all the digits into ascending order
        // 2. find the smallest missing positive integer

        // Note:
        // 0 is neither positive nor negative

        int length = nums.length;
        int temp;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }


        return nums;
    }

    public static int method2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }

        for(int i = 0; i < nums.length; i++){
            while(  nums[i] <= nums.length &&
                    nums[i] > 0 &&
                    nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }

        }
        int i = 0;

        while(i < nums.length && nums[i] == i + 1){
            i++;
        }

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
    }
}
