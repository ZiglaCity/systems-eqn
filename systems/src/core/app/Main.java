package core.app;

import core.algorithms.*;
import core.utils.Utils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[][] A = new double[4][4];
        A[0] = new double[]{3, 2, 0, 0};
        A[1] = new double[]{2, 3, 2, 0};
        A[2] = new double[]{0, 2, 3, 2};
        A[3] = new double[]{0, 0, 2, 3};

        double[] d = new double[]{12, 17, 14, 7};
//        Thomas thomas = new Thomas(A, d);
//        double[] result = thomas.ThomasAlgorithm();
//        System.out.println("Final result after thomas Algorithm: \n " + Arrays.toString(result));

//        Jacobi jacobi = new Jacobi(A, d, null);
//        double[] jacobResult = jacobi.JacobiAlgorithm(20);
//        System.out.println("Final answer after "+ 5 + " iterations " + Arrays.toString(jacobResult));

        GaussSeidel seidel = new GaussSeidel(A, d, null);
        double[] seidelResult = seidel.GaussSeidelAlgorithm(20);
        System.out.println("Final answer after "+ 20 + " iterations " + Arrays.toString(seidelResult));

//        double[][] B = new double[2][3];
//        B[0] = new double[]{1, 3, 2};
//        B[1] = new double[]{2, 0, 1};

//        Utils.toString(Matrix.MatrixAddition(A, B));
//        Utils.toString(Matrix.MatrixSubtraction(A, B));
//        Utils.toString(Matrix.MatrixMultiplication(A, B));

    }
}