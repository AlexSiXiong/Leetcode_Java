import java.util.ArrayList;
import java.util.List;

public class Awesome_46_Permutations {

    /*
    2020.03.30

    Given a collection of distinct integers, return all possible permutations.

    Input: [1,2,3]

    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]

    150 min

    考点：
    1. 如何将现实问题转化成程序
    2. 深拷贝
    3. 递归

    TODO：
    DP
    优化原方法，使用了很多内存
    */

    private static List<List<Integer>> method1(int[] nums) {

        List<List<Integer>> final_result = new ArrayList<>();
        List<Integer> initial = new ArrayList<>();

        List<List<Integer>> current = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int to_be_insert = nums[i];

            if (i == 0) {
                current = insert2(initial, to_be_insert);
            } else {
                current = insert1(current, to_be_insert);
            }
        }

        return current;
    }

    private static List<List<Integer>> insert1 (List<List<Integer>> temp_result, int insert_num) {
        List<List<Integer>> big = new ArrayList<>();
        for (int i = 0; i < temp_result.size(); i++) {
            List<List<Integer>> temp = insert2(temp_result.get(i), insert_num);
            big.addAll(temp);
        }
        return big;
    }

    private static List<List<Integer>> insert2 (List<Integer> child_list, int insert_num) {
        List<List<Integer>> result = new ArrayList<>();
        int length = child_list.size();
        List<Integer> temp = new ArrayList<>(child_list);
        for (int j = 0; j < length + 1; j++) {
            temp.add(j, insert_num);
            List<Integer> temp2 = new ArrayList<>(temp);
            result.add(temp2);
            temp.remove(j);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
//        temp.add(1);
//        List<List<Integer>> result = insert2(temp, 3);
//        System.out.println(result);
//
//        List<List<Integer>> big = new ArrayList<>();
//        for (int i = 0; i < result.size(); i++) {
//            List<List<Integer>> temp0 = insert2(result.get(i), 10);
//            for (int j = 0; j < temp0.size(); j++) {
//                System.out.println(temp0.get(j));
//                big.add(temp0.get(j));
//            }
//        }
//        System.out.println(big);

        int[] a = {1,2};
        System.out.println(method1(a));
    }
}
