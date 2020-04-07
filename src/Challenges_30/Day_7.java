package Challenges_30;

import java.util.HashMap;

public class Day_7 {
    /*
    2020.04.07

    day 7

    Given an integer array arr, count element x such that x + 1 is also in arr.

    If there're duplicates in arr, count them seperately.

    60 min

    理解错了题意，绕了半天

     */
    public static int countElements(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int result = 0;

        bubble_sort(arr);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if(map.containsKey(current)) {
                // 当前的添加一个
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }

            if (i >= 1) {
                if (arr[i] != arr[i - 1]) {
                    if (map.containsKey(current - 1)) {
                        System.out.println("current - 1 = " + (current - 1));
                        result += map.get(current - 1);
                    }
                }
            }

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

    public static int countElements2(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if(map.containsKey(current)) {
                // 当前的添加一个
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        for (int digit: map.keySet()) {
            if (map.containsKey(digit - 1)) {
                result += map.get(digit - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,3,3};
        System.out.println(countElements2(a));
    }
}
