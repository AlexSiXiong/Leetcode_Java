public class Awesome_35_SearchInsertPosition {
    /*
    2019.11.11

    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Example 1:

    Input: [1,3,5,6], 5
    Output: 2
    Example 2:

    Input: [1,3,5,6], 2
    Output: 1
    Example 3:

    Input: [1,3,5,6], 7
    Output: 4
    Example 4:

    Input: [1,3,5,6], 0
    Output: 0

    Path in brain:
    The result starts from index 0

    1. equals -> return the corresponding position

    2. larger -> index of the next position
    3. smaller -> index of the previous position
     */

    private static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int smallest = nums[left];
        int biggest = nums[right];
        if (target <= smallest) {
            return 0;
        }
        if (target > biggest) {
            return right + 1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1; // Last round. It exits the loop in the next round.
            }
        }
        int index = left;
        return index;
    }

    public static void main(String[] args) {
        int[] t = {1,3};
        int target = 2;
        int result = searchInsert(t, target);
        System.out.println(result);

    }
}
