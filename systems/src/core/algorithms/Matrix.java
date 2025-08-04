package core.algorithms;

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

    public static double getMax(double[] array){
        double largest = array[0];
        for(double number: array){
            if (number > largest){
                largest = number;
            }
        }
        return largest;
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
}
