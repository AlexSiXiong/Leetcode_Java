public class Awesome_26_RemoveDuplicatesFromSortedArray {
    /*
    2020.03.28

    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    Done in 10 min.
    */

    private static int method1(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int anchor = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                anchor += 1;
                nums[anchor] = nums[i];
            }
        }
        return anchor + 1;
    }

    public static void main(String[] args) {
        int[] sample = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(method1(sample));
        System.out.println("----");
        for(int i = 0; i < sample.length; i++) {
            System.out.println(sample[i]);
        }
    }
}
