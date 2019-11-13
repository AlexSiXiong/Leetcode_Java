import java.util.HashMap;
import java.util.Map;

public class Awesome_36_ValidSudoku {
    /*
    2019.11.13

    * Matrix

    Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    Path in brain:
    solve three sub-questions one by one

    checking Q.54
     */
    public boolean isValidSudoku(char[][] board) {
        int col = board[0].length;
        int row = board.length;
        // row checking
        for (int i = 0; i < row; i++) {
            char[] eachRow = board[i];
            if (!rowOrColChecking(eachRow)) {
                return false;
            }
        }

        // col checking
        for (int i = 0; i < col; i++) {
            char[] eachCol = new char[9];
            for (int j = 0; j < row; j++) {
                eachCol[j] = board[j][i];
            }
            if (!rowOrColChecking(eachCol)) {
                return false;
            }
        }

        // 3 x 3 checking
        // 这个不常做到，多练习
        // this is rare， need more practice
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                char[] eachBox = extractThreeByThreeBox(i, j, board);
                if (!rowOrColChecking(eachBox)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean rowOrColChecking(char[] eachCol) {
        Map<Character, Integer> dic = new HashMap<>();
        for (char currentDigit : eachCol) {
            if (currentDigit >= 48 && currentDigit <= 57) {
                if (dic.containsKey(currentDigit)) {
                    return false;
                } else {
                    dic.put(currentDigit, 1);
                }
            }
        }
        return true;
    }

    private char[] extractThreeByThreeBox(int col, int row, char[][] board) {
        char[] box = new char[9];
        int n = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    box[n] = board[row + i][col + j]; // careful
                    n++;
                }
            }

        return box;
    }
}