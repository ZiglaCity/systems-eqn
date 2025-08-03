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
}
