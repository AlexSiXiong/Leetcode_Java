package Longest;

class Longest {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int shortest = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortest) {
                shortest = strs[i].length();
            }
        }
        int index = 0;
        while(index < shortest) {
            char anchor = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (anchor != strs[i].charAt(index)) {
                    return result.toString();
                }
            }
            result.append(anchor);
            index += 1;
        }

        return result.toString();

    }

    public static void main(String[] args) {
        String[] input1 = new String[]{"dog","racecar","car"};
        String[] input2 = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(input1));

        System.out.println(longestCommonPrefix(input2));
    }
}