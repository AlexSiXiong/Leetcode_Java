package Weekly.Contest_184;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class a {
    public List<String> stringMatching(String[] words) {
        return null;
    }

    public static void main(String[] args) {
        HashSet<String> result = new HashSet<>();
        String[] words  = {"leetcode","et","code"};
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {

                } else if (words[i].contains(words[j])) {
                    result.add(words[j]);

                }
            }
        }
//
//        String a = "abc";
//        String b = "bc";
//        System.out.println(a.contains(b));
        List<String> result2 = new ArrayList<>(result);
        for(String i : result2) {
            System.out.println(i);
        }
    }
}
