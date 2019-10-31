public class Awesome_10_RegularExpressionMatching {
    /*
    2019.10.18
    first try
     */
    // i = 0 1 2 3 4
    // p = a x a a b
    // s = a a b

    // Misunderstood the question
    // . -> any character
    // * -> any character

    // Right way should be like
    // . -> any character
    // * -> repeat 0 or any time of the one previous character
    private static boolean isMatch_Went_Wrong(String s, String p) {
        if (p.length() < s.length()) return false;
        char sStart = s.charAt(0);
        boolean startCompare = false;
        int anchor = 0;
        for (int i = 0; i < p.length(); i++) {
            char pCurrent = p.charAt(i);
            if (!startCompare) {
                anchor = i;
                if (sStart == pCurrent || pCurrent == '.' || pCurrent == '*') {
                    startCompare = true;
                }
            } else {
                char sCurrent = s.charAt(i - anchor);
                if (pCurrent != '.' && pCurrent != '*') {
                    if (pCurrent != sCurrent) {
                        startCompare = false;
                    }
                }
                if (i + 1 - anchor == s.length()) return true;
            }
        }
        return false;
    }

    // Draft
//    private static boolean isMatch(String s, String p) {
//        if (p.isEmpty()) return s.isEmpty();
//        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
//        return first_match && isMatch(s.substring(1), p.substring(1));
//    }


    // i = 0 1 2 3 4

    // p = a * a * b
    // s = a a b

    private static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {

            //pattern 直接跳过两个字符。表示 * 前边的字符出现 0 次
            //pattern 不变，例如 text = aa ，pattern = a*，第一个 a 匹配，然后 text 的第二个 a 接着和 pattern 的第一个 a 进行匹配。表示 * 用前一个字符替代。

            return (isMatch(s, p.substring(2)) ||
                    // 第一种情况，比如 p = c * a *
                    //                s = a a
                    // 要把 p 里的 c* 两个位置的字符串跳过

                    // 第一种情况这样写是错的
                    // (!first_match && isMatch(s, p.substring(2))
                    // p = a * a
                    // s = a a a
                    (first_match && isMatch(s.substring(1), p))); // 这是第二种情况，把s的第二位和p的第一位比较，反正 * 就是前面的一个字符
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }


    public static void main(String[] args) {
        String s = "ab";
        String p = ".*c";
        String bb = "abc";
        System.out.println(bb.substring(2));
    }
}
