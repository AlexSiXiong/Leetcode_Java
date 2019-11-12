public class Awesome_34_FindFirstandLastPositionofElementinSortedArray {
    /*

    2019.11.12
    * Binary
    * Sorted Arr

    Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    Example 1:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    Example 2:

    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

    Path in brain:

     */
    private static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;

        int left = 0;
        int right = nums.length - 1;
        // single elements in the arr
        if (right == 0) {
            if (nums[0] == target) {
                return new int[] {0,0};
            }
        }

        while (left <= right) { // Be really careful with this condition
                                // left < right  vs.  left <= right
            int mid = (left + right) / 2;

            // find the target
            // check its left and right
            if (target == nums[mid]) {
                start = mid;
                while(start - 1 >= 0 && nums[start - 1] == target) {
                    start -= 1;
                    if (start == 0) {
                        break;
                    }
                }
                end = mid;
                while (end + 1 <= nums.length - 1 && nums[end + 1] == target ) {
                    end += 1;
                    if (end == nums.length - 1) {
                        break;
                    }
                }
                left = right + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{start, end};
    }

    private static void printList(int[] input){
        System.out.print('[');
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            if (i != input.length - 1) {
                System.out.print(',');
            }
        }
        System.out.print(']');
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] set1 = {5,7,7,8,8,10};
//        int target1 = 8;
//        printList(searchRange(set1, target1));
        int[] set2 = {2,2};
        int target2 = 1;

        printList(searchRange(set2, target2));
    }
}
