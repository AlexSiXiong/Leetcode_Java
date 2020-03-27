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

    Input: [1,2,0,2,1]
    Output: 3

    Input: [1,2,2,2,2,3,1]
    Output: 4
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
        // 不断的往后找

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

        int anchor = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
            } else if (nums[i] > 0) {
                if (nums[i] == anchor) {
                    anchor+=1;
                } else if (i >= 1 && nums[i] == nums[i - 1]){
                    // Boundary !!
                }
                else {
                    break;
                }
            }
        }
        return anchor;
    }



    public static void main(String[] args) {
        int[] a = {1,2,2,2,2,3,1};
        int[] nums = method1(a);

        // 0,1,1,2,2
        // 0,3,3,4,4
        int anchor = 1;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums["+i+"] " +nums[i]);
            System.out.println("anchor "+ anchor);
            if (nums[i] <= 0) {
            } else if (nums[i] > 0) {
                if (nums[i] == anchor) {
                    anchor+=1;
                } else if (i >= 1 && nums[i] == nums[i - 1]){

                }
                else {
                    break;
                }
            }
        }
        System.out.println("final " + anchor);

    }
}
