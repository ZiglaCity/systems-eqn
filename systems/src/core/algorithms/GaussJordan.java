package core.algorithms;

import java.util.Arrays;

public class GaussJordan {
    public static double[] GaussianElimination(double[][] A, Integer[] b){
        int n = b.length;

        for (int p = 0; p < n; p++) {
            // Find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }

            // Swap rows in A
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;

            // Swap values in b
            double t = b[p];
            b[p] = b[max];
            b[max] = (int) t;

            if (Math.abs(A[p][p]) <= 1e-10) {
                throw new ArithmeticException("Matrix is singular or nearly singular, there could be no solution or infinitely many solutions, but not a unique solution.");
            }

            // Pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= (int) (alpha * b[p]);
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // Back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }

        return x;
    }

}
