import java.util.Random;

public class Awesome_33_SearchRotatedSortedArray {
    /*
    2019.11.10

    * Two pointers

    Tomorrow is the 'black friday' in china!

    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.

    ! - Your algorithm's runtime complexity must be in the order of O(log n).

    Example 1:

    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
    Example 2:

    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

    Path in brain:
    O(log n) means that half of the numbers in the array have to be eliminated each round.

    奇数然后偶数

    0 1 [2] 3 4
    1 2  3  4 0
                       t = 3, t == mid  -> return [index]
                       t = 0, t < mid && t < start -> right
                       t = 2, t < mid && t >= start -> left
                       t = 4, t > mid && t >= end -> error

    4 0  1 2 3         t = 4, t > mid && t > end -> left
                       t = 3, t > mid && t <=end -> right

    right +
    left  -


    0 1 2 [3] 4 5

    midCuttingIndex = s.length() / 2
    midCuttingNumber = arr[midIndex]

    rightIndex = midIndex;

    if target < mid {
        left
    }

    if target > mid {
        right
    }

    if target == mid {
        return midIndex
    }

    怎么记录这个index
          m
    0 1 2 3 4 5 6 7
    4 5 6 7 8 1 2 3
     */

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // This is the stop condition
            if (target == nums[mid]) {
                return mid;
            }
//            this method will have error (marked above)
//
//            if (target < nums[mid]) {
//                if (target < nums[left]) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            } else { // target < nums[mid]
//                if (target > nums[right]) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }

            // this method avoid that error
            if (nums[mid] > nums[right]) {
                // left hand side is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // nums[mid] < nums[right]
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // Recursion
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target && nums[mid] < nums[start] && target > nums[end]) {
            return search(nums, target, start, mid - 1);
        }
        if (nums[mid] < target) return search(nums, target, mid + 1, end);
        if (nums[mid] > target && nums[mid] > nums[end] && target < nums[start]) {
            return search(nums, target, mid + 1, end);
        }
        return search(nums, target, start, mid - 1);
    }

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(14) + 1);
    }
}
