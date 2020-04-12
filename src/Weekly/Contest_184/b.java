package Weekly.Contest_184;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class b {
    public static int[] processQueries(int[] queries, int m) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> p = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            p.add(i+1);
        }
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i];
            for (int j = 0; j < p.size(); j++) {
                if (index == p.get(j)){
                    result.add(j);
                    int removed = p.remove(j);
                    p.addFirst(removed);
                }
            }
        }
        int[] result2 = new int[result.size()];
        for (int i = 0; i < result2.length; i++) {
            result2[i] = result.get(i);
        }
        return  result2;
    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        int[] queries = {7,5,5,8,3};
        int m = 8;

        LinkedList<Integer> p = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            p.add(i+1);
        }
//        int to_remove = p.remove(4);
//        p.addFirst(to_remove);
////        p.addFirst(3);
//
//        for(int i : p) {
//            System.out.println(i);
//        }


        for (int i = 0; i < queries.length; i++) {
//            System.out.println("i = " + i);
            int index = queries[i];
//            System.out.println("index = " + index);


            for (int j = 0; j < p.size(); j++) {


                if (index == p.get(j)) {
//                    System.out.println("j = "+ j);
//                    System.out.println("value = " + p.get(j));
                    result.add(j);
                    int removed = p.remove(j);
                    p.addFirst(removed);
                }
            }

        }


        int[] kk = processQueries(queries, m);
        for (int i : kk) {
            System.out.println(i);
        }
    }
}
