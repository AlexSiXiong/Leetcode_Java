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
        // 滑窗法
        // 要考虑边界情况

        // 1. 二分法
        // 2. 核心策略：只有在相邻3天股价为 <小-大-小> 才卖出
        if (prices.length < 2) {
            return 0;
        }

        if (prices.length == 2) {
            if ((prices[1] - prices[0]) > 0) {
                return prices[1] - prices[0];
            }
        }

        int sum = 0;
        int buy = 0;
        boolean brought = false;
        int local_max = 0;
        for (int i = 2; i < prices.length; i++) {
            int first = prices[i - 2];
            int second = prices[i - 1];
            int third = prices[i];

            if (first < second) {
                if (second > third) {
                    if (brought) {
                        sum += second - buy;
                        buy = 0;
                        brought = false;
                    } else {
                        sum += second - first;
                    }
                } else { // second <= third
                    if (! brought) {
                        buy = first;
                        local_max = third;
                        brought = true;
                        if (i == prices.length - 1) {
                            sum += local_max - buy;
                            brought = false;
                        }
                    } else {
                        if (third > local_max) {
                            local_max = third;
                            if (i == prices.length - 1) {
                                sum += local_max - buy;
                                brought = false;
                            }
                        }
                    }
                }
            }

            if (first >= second) {

                if (i == prices.length - 1) {
                    if (third > second) {
                        sum += third - second;
                    }
                }
                // Corner cases:
                // such as {2,6,6,2,1}
                if (brought && first == second) {
                    sum += local_max - buy;
                    brought = false;
                }
            }
        }
        return sum;
    }

    private static int method2(int[] prices) {
        // Reference:
        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/552544/Java-Greedy-w-visualization

        // 这是在网上看到的
        // 不知道为什么这样也可以，因为这个代码从语义上直接说说不通
        // 作者说是贪心算法
        // 实质也是数学

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int earn = prices[i] - prices[i - 1];
            if (earn > 0) {
                sum += earn;
            }
        }
        return sum;
    }

    private static int method3(int[] prices) {
        int sum = 0;
        int i = 0;
        while (i < prices.length) {

            while(i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                // 如果股价一直下降
                i++;
            }
            int min = prices[i];
            i++;

            while(i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                // 如果股价一直上升
                i++;
            }

            if (i < prices.length) {
                int max = prices[i];
                sum += (max - min);
            } else {
                sum += 0;
            }
        }
        return sum;
    }



    public static void main(String[] args) {
//        int[] price = {5,2,3,2,6,6,2,9,1,0,7,4,5,0};
        int[] price = {2,6,7,2,1};
        System.out.println(method1(price));
    }
}
