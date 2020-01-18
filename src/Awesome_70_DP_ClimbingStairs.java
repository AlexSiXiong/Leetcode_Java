public class Awesome_70_DP_ClimbingStairs {
    /*
    2020.01.18

    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps.
    In how many distinct ways can you climb to the top?

    Example 1:
    Input: 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:
    Input: 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

    *
    1. climbing one stair has one one way - 1 stop
    2. climbing two stair has two ways - 1 step + 1 step  or  2 step
    These two ways are the base lines of climbing stairs

    Formulation : f(n) = f(n - 1) + f(n - 2)

    careful - boundary and the return Index
     */


    private static int climbStairs(int n) {
        if (n < 3) return n;

        int[] stairs = new int[n + 1];
        stairs[1] = 1;
        stairs[2] = 2;
        for(int i = 3; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }

        return stairs[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

}
