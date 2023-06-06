public class Question_7 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;

        while (num <= n * n) {
            // Fill top row
            for (int j = colStart; j <= colEnd; j++) {
                matrix[rowStart][j] = num;
                num++;
            }
            rowStart++;

            // Fill right column
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num;
                num++;
            }
            colEnd--;

            // Fill bottom row
            for (int j = colEnd; j >= colStart; j--) {
                matrix[rowEnd][j] = num;
                num++;
            }
            rowEnd--;

            // Fill left column
            for (int i = rowEnd; i >= rowStart; i--) {
                matrix[i][colStart] = num;
                num++;
            }
            colStart++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] result = generateMatrix(n);

        // Print the generated matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
