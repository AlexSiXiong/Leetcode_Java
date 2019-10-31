import java.util.ArrayList;
import java.util.List;

public class Awesome_17_LetterCombinationsofaPhoneNumber {
    /*
    2019.10.19
    first try

    * string/char manipulation

    Given a string containing digits from 2-9 inclusive, return all possible letter
    combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.

    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            // !
            int current_digit = digits.charAt(i) -'0';
            // !
            List<String> current_characteristics = convertToList(current_digit);
            result = timesTwoList(result, current_characteristics);
        }
        return result;
    }

    private static List<String> convertToList(int digit) {
        List<String> result = new ArrayList<>();
        String[] digit_letter = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        String current_digit = digit_letter[digit];
        for (int i = 0; i < current_digit.length(); i++) {
            result.add(String.valueOf(current_digit.charAt(i)));
        }
        return result;
    }

    private static List<String> timesTwoList(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        // this is important
        if (list1.size() != 0 && list2.size() == 0) {
            return list1;
        }
        // this is important
        if (list1.size() == 0 && list2.size() != 0) {
            return list2;
        }
        for (String value1 : list1) {
            for (String value2 : list2) {
                result.add(value1 + value2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> temp = letterCombinations("23");
        String a = temp.get(0);
        System.out.println(a);

    }
}
