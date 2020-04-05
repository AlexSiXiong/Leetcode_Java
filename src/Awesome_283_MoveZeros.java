import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Awesome_283_MoveZeros {
    /*
    2020.04.04

    30 days challenge

    day 4

    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Example:
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Note:
    1. You must do this in-place without making a copy of the array.
    2. Minimize the total number of operations.

    12 min

    two pointers
    queue
     */

    private static void method1(int[] nums) {

        Queue<Integer> index_none_zero = new LinkedList<>();
        int times = 0;
        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];

            if (current == 0) {
                index_none_zero.offer(i);
                times++;
            } else {
                if (times != 0) {
                    int zero_index = index_none_zero.poll();
                    nums[i] = 0;
                    nums[zero_index] = current;
                    index_none_zero.offer(i);
                    // Note: the zero should be put back into the Queue
                    //
                    // [0a,0b,2,3,4] -> [2,0b,0a,3,4] -> [2,3,0a,0b,4] -> [2,3,4,0b,0a]

                }
                }

        }
    }

    private static void method2(int[] nums) {
        // 这个做法就是直接把非0位重数组开头填上去
        // 在第二个for循环的时候从最后一个位置开始把0全部填上去
        if(nums.length == 0){
            return;
        }


        int index = 0;
        for(int digit : nums){
            if(digit != 0){
                nums[index] = digit;
                index++;
            }

        }

        for(int i = index; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] temp = {0,0};
        method1(temp);
        for(int i : temp) {
            System.out.println(i);
        }
    }
}
