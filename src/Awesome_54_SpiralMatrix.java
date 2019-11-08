import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Awesome_54_SpiralMatrix {
    /*
    2019.11.08

    * this question is interesting !

    Given a matrix of m x n elements (m rows, n columns),
    return all elements of the matrix in spiral order.

    Input:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    Output: [1,2,3,6,9,8,7,4,5]

    Input:
    [
      [1, 2, 3, 4],
      [5, 6, 7, 8],
      [9,10,11,12]
    ]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int totalDigits = row * col;

        int leftStopIndex = -1;
        int rightStopIndex = col; // the length of col
        int bottomStopIndex = row; // the length of row
        int topStopIndex = -1;

        // Numeric keypad
        // 2, 4, 8, 6 = down, left, top, right
        int direction = 6;
        boolean running = true;

        int colIndex = 0;
        int rowIndex = 0;

        while(true) {
            if (result.size() == totalDigits) {
                return result;
            }
            result.add(matrix[rowIndex][colIndex]);
            switch (direction) {
                case 6: // right
                    if (colIndex + 1 < rightStopIndex) { // check next step
                        colIndex++;
                    } else {
                        // boundary check
                        direction = 2;
                        topStopIndex++;
                        rowIndex++;
                    }
                    break;
                case 2: // down
                    if(rowIndex + 1 < bottomStopIndex) {
                        rowIndex++;
                    } else {
                        direction = 4;
                        rightStopIndex--;
                        colIndex--;
                    }
                    break;
                case 4: // left
                    if (colIndex - 1 > leftStopIndex) {
                        colIndex--;
                    } else {
                        direction = 8;
                        bottomStopIndex--;
                        rowIndex--;
                    }
                    break;
                case 8: // top
                    if (rowIndex - 1 > topStopIndex) {
                        rowIndex--;
                    } else {
                        direction = 6;
                        leftStopIndex++;
                        colIndex++;
                    }
                    break;
            }
        }
    }

    private static int[][] convertStringToMatrix(int[] input, int row, int col) {
        int[][] matrix = new int[row][col];
        int index = 0;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                int digit = input[index];
                // chat -> int  --- Ascii
                matrix[x][y] = digit;
                index++;
            }
        }
        return matrix;
    }

    private static void displayMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.print('[');
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
                if (col != matrix[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(']');
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        displayMatrix(convertStringToMatrix(test1, 3,3));
        int[][] testCase1 = convertStringToMatrix(test1, 3,3);
        List<Integer> resultOfTestCase1 = spiralOrder(testCase1);
        int[] resultList = new int[resultOfTestCase1.size()];

        for (int i = 0; i < resultList.length; i++) {
            resultList[i] = resultOfTestCase1.get(i);
        }
        int[] answerList = {1,2,3,6,9,8,7,4,5};
        System.out.println(Arrays.equals(resultList, answerList));
        }


}
