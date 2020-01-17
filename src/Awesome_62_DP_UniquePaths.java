import java.util.ArrayList;

public class Awesome_62_DP_UniquePaths {
    /*
    2020.01.17
    DP

    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?

    *
    1. How to create 2d list

    2. How to access a 2d list
       - Matrix[row][col]

    3. Dynamic planning (Careful - boundary)
       the for loop starts from i = 1 and j = 1
       1) if it starts from 0, then the matrix will going to access [-1][0] or [0][-1]
       2) the starting point is [0][0](base line), dp cannot and would never be starting from the base line
    */
    private static int uniquePaths(int col, int row) {
        int[][] matrix = new int[row][col];

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }


        return matrix[row - 1][col - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
