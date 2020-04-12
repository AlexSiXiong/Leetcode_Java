package Weekly.Contest_184;

import java.util.HashMap;

public class c {
    public static void main(String[] args) {
        String text = "1.&amp; is an HTML entity but &ambassador; is not.//2.and I quote: &quot;...&quot;//3.Stay home! Practice on Leetcode :)//4.x &gt; y &amp;&amp; x &lt; y is always false";
        HashMap<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        for (String key: map.keySet()) {
            text = text.replaceAll(key, map.get(key));
        }
        String test2 = "1.& is an HTML entity but &ambassador; is not.//2.and I quote: \"...\"//3.Stay home! Practice on Leetcode :)//4.x > y && x < y is always false";

        System.out.println(text.equals(test2));
        char[] first = text.toCharArray();
        char[] second = test2.toCharArray();
        for (int i =0 ; i < first.length; i++) {
            if (first[i] != second[i]) {
                System.out.println(first[i]);
                System.out.println(i);
            }
        }
        System.out.println("----");
        System.out.println(text);
        System.out.println(test2);
    }
}
