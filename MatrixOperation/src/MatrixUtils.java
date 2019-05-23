import java.util.Scanner;

public class MatrixUtils {

    public static int rowsNumberInput() {

        System.out.println("Please enter the number of rows for the matrix: ");
        Scanner scRows = new Scanner(System.in);
        int rows = scRows.nextInt();
        System.out.println("The number of rows is " + rows);
        return rows;
    }

    private static int columnsNumberInput() {
        System.out.println("Please enter the number of сolumns for the matrix: ");
        Scanner scColumns = new Scanner(System.in);
        int columns = scColumns.nextInt();
        System.out.println("The number of columns is " + columns);
        return columns;
    }

    private static int[][] inputMatrix(int rows, int columns) {
        int inputMatrix[][] = new int[rows][columns];
        // User input values for matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Please input value for element " + i + j);
                Scanner sc = new Scanner(System.in);
                int matrixElement = sc.nextInt();
                inputMatrix[i][j] = matrixElement;
                System.out.println("Matrix element is " + matrixElement);
            }
        }
        //Display inputted matrix
        System.out.println("Your inputted matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(inputMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        return inputMatrix;
    }

    private static void transposeMatrix(int rows, int columns, int[][] inputMatrix) {
        /*During the transpose operation, the columns and rows are swapped,
        and we must take this into account in the new transposed matrix.
        */
        int rowsTransposedMatrix = columns;
        int columnsTransposedMatrix = rows;
        int transposedMatrix[][] = new int[rowsTransposedMatrix][columnsTransposedMatrix];

        //Transpose matrix

        for (int i = 0; i < rowsTransposedMatrix; i++) {
            for (int j = 0; j < columnsTransposedMatrix; j++) {
                transposedMatrix[i][j] = inputMatrix[j][i];
            }
        }
        //Display transposed matrix
        System.out.println("Your transposed matrix is:");
        for (int i = 0; i < rowsTransposedMatrix; i++) {
            for (int j = 0; j < columnsTransposedMatrix; j++) {
                System.out.print(transposedMatrix[i][j] + "\t");
            }
            System.out.println();
        }

    }


    public static void main(String... args) {

        int rows = rowsNumberInput();
        int columns = columnsNumberInput();
        int[][] inputMatrix = inputMatrix(rows, columns);
        transposeMatrix(rows, columns, inputMatrix);

    }


}
