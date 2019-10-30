import java.util.ArrayList;
import java.util.List;

public class Alex_6_ZigZagConversion {
    /*
    2019.10.16 - First try

    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R

    "PAHNAPLSIIGYIR"

    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"

    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:

    P     I    N
    A   L S  I G
    Y A   H R
    P     I
     */

    private static String method1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean down = false;

        char[] chars = s.toCharArray();
        for (char currentChar : chars) {
            rows.get(currentRow).append(currentChar);
            // First, check the program is going down or going up
            if (currentRow == 0 || currentRow + 1 == numRows) {
                down = !down;
            }
            // 1  means going down
            // -1 means going up
            currentRow += down ? 1 : -1;
        }

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
