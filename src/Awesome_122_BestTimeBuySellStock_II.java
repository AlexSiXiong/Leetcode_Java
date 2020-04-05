public class Awesome_122_BestTimeBuySellStock_II {
    /*
    2020.04.05

    30 days challenge

    day 5

    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like
    (i.e., buy one and sell one share of the stock multiple times).

    Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

    考点：

    一开始没思路
    后来看了一下121题，感觉可以试一试用双指针做

    22:51
    10 min 找了一下规律, 4指针。。。
    15 min 滑窗法

    想复杂了
    其实好简单
     */

    private static int method1(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }

        if (prices.length == 2) {
            if ((prices[1] - prices[0]) > 0) {
                return prices[1] - prices[0];
            }
        }

        int sum = 0;
        return sum;
    }

    private static int method2(int[] prices) {
        // Reference:
        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/552544/Java-Greedy-w-visualization

        // 这是在网上看到的
        // 不知道为什么这样也可以，因为这个代码从语义上直接说说不通
        // 据说是贪心算法

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int earn = prices[i] - prices[i - 1];
            if (earn > 0) {
                sum += earn;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] price = {3,5,3,5};

        System.out.println(method1(price));
    }
}
