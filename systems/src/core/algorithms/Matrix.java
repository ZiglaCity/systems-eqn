package core.algorithms;

import core.utils.Utils;

public class Matrix {

    public static double[][] MatrixMultiplication (double[][] matrixA, double[][] matrixB){
        int rowA = matrixA.length;
        int colA = matrixA[0].length;
        int rowB = matrixB.length;
        int colB = matrixB[0].length;

        if (colA != rowB){
            System.out.println("Matrix A and B are not compatible");
            throw new Error("The matrices are not compatible");
        }

        double[][] matrixAB = new double[rowA][colB];
        for (int r = 0; r < rowA; r++){
            for (int c = 0; c < colB; c++){
                matrixAB[r][c] = 0.0;
                for (int x = 0; x < colA; x++){
                    matrixAB[r][c] += (matrixA[r][x] * matrixB[x][c]);
                }
            }
        }
        return matrixAB;
    }

    public static double[][] MatrixMultiplication (int[][] matrixA, int[][] matrixB){
        int rowA = matrixA.length;
        int colA = matrixA[0].length;
        int rowB = matrixB.length;
        int colB = matrixB[0].length;

        if (colA != rowB){
            System.out.println("Matrix A and B are not compatible");
            throw new Error("The matrices are not compatible");
        }

        double[][] matrixAB = new double[rowA][colB];
        for (int r = 0; r < rowA; r++){
            for (int c = 0; c < colB; c++){
                matrixAB[r][c] = 0.0;
                for (int x = 0; x < colA; x++){
                    matrixAB[r][c] += (matrixA[r][x] * matrixB[x][c]);
                }
            }
        }
        return matrixAB;
    }

    public static double[] MatrixMultiplication (double[][] matrixA, double[] matrixB){
        int rowA = matrixA.length;
        int colA = matrixA[0].length;
        int rowB = matrixB.length;
        int colB = 1;

        if (colA != rowB){
            System.out.println("Matrix A and B are not compatible");
            throw new Error("The matrices are not compatible");
        }

        double[] matrixAB = new double[rowA];
        for (int r = 0; r < rowA; r++){
            for (int c = 0; c < colB; c++){
                matrixAB[r] = 0.0;
                for (int x = 0; x < colA; x++){
                    matrixAB[r] += (matrixA[r][x] * matrixB[x]);
                }
            }
        }
        return matrixAB;
    }

    public static double MatrixMultiplication(double[] A, double[] B){
        double res = 0;
        for(int i = 0; i < A.length; i++){
            res += A[i] * B[i];
        }
        return res;
    }

    public static double[][] MatrixAddition(double[][] A, double[][] B){
        int rowA = A.length;
        int rowB = B.length;
        int colA = A[0].length;
        int colB = B[0].length;
        if(rowA != rowB || colA != colB){
            System.out.println("The 2 matrices cannot be added due to difference in sizes");
            throw new Error("The matrices cannot be added: due to difference in sizes");
        }
        double[][] result = new double[rowA][colA];
        for(int r = 0; r < rowA; r++){
            for (int c = 0; c < colA; c++){
                result[r][c] = A[r][c] + B[r][c];
            }
        }
        return result;
    }

    public static int[][] MatrixAddition(int[][] A, int[][] B){
        int rowA = A.length;
        int rowB = B.length;
        int colA = A[0].length;
        int colB = B[0].length;
        if(rowA != rowB || colA != colB){
            System.out.println("The 2 matrices cannot be added due to difference in sizes");
            throw new Error("The matrices cannot be added: due to difference in sizes");
        }
        int[][] result = new int[rowA][colA];
        for(int r = 0; r < rowA; r++){
            for (int c = 0; c < colA; c++){
                result[r][c] = A[r][c] + B[r][c];
            }
        }
        return result;
    }

    public static double[][] MatrixSubtraction(double[][] A, double[][] B){
        int rowA = A.length;
        int rowB = B.length;
        int colA = A[0].length;
        int colB = B[0].length;
        if(rowA != rowB || colA != colB){
            System.out.println("The 2 matrices cannot be subtracted due to difference in sizes");
            throw new Error("The matrices cannot be subtracted: due to difference in sizes");
        }
        double[][] result = new double[rowA][colA];
        for(int r = 0; r < rowA; r++){
            for (int c = 0; c < colA; c++){
                result[r][c] = A[r][c] - B[r][c];
            }
        }
        return result;
    }

    public static int[][] MatrixSubtraction(int[][] A, int[][] B){
        int rowA = A.length;
        int rowB = B.length;
        int colA = A[0].length;
        int colB = B[0].length;
        if(rowA != rowB || colA != colB){
            System.out.println("The 2 matrices cannot be subtracted due to difference in sizes");
            throw new Error("The matrices cannot be subtracted: due to difference in sizes");
        }
        int[][] result = new int[rowA][colA];
        for(int r = 0; r < rowA; r++){
            for (int c = 0; c < colA; c++){
                result[r][c] = A[r][c] - B[r][c];
            }
        }
        return result;
    }

    public static boolean isIdenticalMatrix(double[][] A, double[][] B){
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (rowsA != rowsB || colsA != colsB){
            return false;
        }

        for (int r = 0; r < rowsA; r++){
            for(int c = 0; c < colsA; c++){
                if (A[r][c] != B[r][c] && Math.round(A[r][c]) != Math.round(B[r][c])){
                    return false;
                }
            }
        }

        return true;
    }

    public static double getMax(double[] array){
        double largest = array[0];
        for(double number: array){
            if (number > largest){
                largest = number;
            }
        }
        return largest;
    }

    public static double[][] Transpose(double[][] A){
        int rows = A.length;
        int cols = A[0].length;
        double[][] AT = new double[cols][rows];
        for(int r = 0; r < cols; r++){
            for (int c = 0; c < rows; c++){
                AT[r][c] = A[c][r];
            }
        }
        return AT;
    }

    public static double[][] Transpose(double[] A){
        Utils.toString(A);
        int rows = 1;
        int cols = A.length;
        double[][] AT = new double[rows][cols];
        for (int c = 0; c < rows; c++){
            AT[0][c] = A[c];
        }
        Utils.toString(AT);

        return AT;
    }


    public static double Magnitude(double[] A){
        double sum_of_squares = 0;
        for(double number : A){
            sum_of_squares += Math.pow(number, 2);
        }
        return Math.sqrt(sum_of_squares);
    }

    public static double[][] MatrixInverse(double[][] A){
        int rows = A.length;
        int cols = A[0].length;
        double[][] inverse = new double[rows][cols];

//        will do that later...
        return inverse;
    }

    public static double Determinant(double[][] A){
//        determinant of a matrix bro(easy?? prolly, complex?? swears!)... nah i think i'll do it later

        return -1;
    }

    public static double[] MatrixAddition(double[] A, double[] B) {
        double[] sum = new double[A.length];
        for (int i = 0; i < A.length; i++){
            sum[i] = A[i] + B[i];
        }
        return sum;
    }

    public static double[] MatrixSubtraction(double[] A, double[] B) {
        double[] diff = new double[A.length];
        for (int i = 0; i < A.length; i++){
            diff[i] = A[i] - B[i];
        }
        return diff;
    }
}
