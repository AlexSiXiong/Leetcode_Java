public class Awesome_80_II_RemoveDuplicatesFromSortedArray {
    /*
    2020.03.28

    Similar to Q.26

    Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    30 min.
    */

    private static int method1(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        // This is different from Q.26

        // Now I need a counter that records the appearances of each digit,
        // and each distinct digit will be stored at most twice.

        boolean twice = false;
        int index = 0;

        // Draft Area
        // [0,0,1,1,1,1,2,3,3]
        //  0,0,1,1,2,3,
        //            e
        //
        // a.[1,1,2,2,2,3]
        // b.[1,1,2,3]
        // c.[1,2,3]
        // d.[1,1,2,2,3,3,3,3] - the last digit
        //
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                twice = true;
            } else if (nums[i] != nums[i - 1]) {
                if (twice) {
                    twice = false;
                    index += 1;
                    nums[index] = nums[i-1];
                    index += 1;
                    nums[index] = nums[i];
                } else {
                    index+= 1;
                    nums[index] = nums[i];
                }
            }
        }
        if(twice) {
            index += 1; // had not wrote this in the first submission.
            nums[index] = nums[nums.length - 1];
        }
        return index + 1;
    }
}
