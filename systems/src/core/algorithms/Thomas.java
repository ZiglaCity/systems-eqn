package core.algorithms;

import core.utils.Utils;

import java.util.Arrays;

public class Thomas {
    private final double[][] A;
    private final double[] d;
    public double[][] initialA;
    public double[] initialD;
    private double[] X;
    private final int rows;

    public Thomas (double[][] A, double[] d){
        int rowA = A.length;
        int colsA = A[0].length;
        int rowD = d.length;
        System.out.println("Checking if matrix A and d are conformable...");
        if(rowA != rowD || rowA != colsA){
            System.out.println("Matrix A, and d are not in form");
            throw new Error("Matrix A, and d are not solvable due to inconsistent sizes");
        }
        System.out.println("Check completed. Valid!");
        this.A = A;
        this.d = d;
        this.initialA = Utils.cloneMatrix(A);
        this.initialD = d.clone();
        this.rows = rowA;
        this.X = new double[this.rows];
    }

    public double[] ThomasAlgorithm(){
        this.confirmTridiagonal();

        double b1 = A[0][0];
        for (int c = 0; c < this.rows; c++){
            A[0][c] /= b1;
        }
        this.d[0] /= b1;

        for(int r = 1; r < this.rows; r++){
            double a_i = A[r][r  - 1];
            for (int c = r - 1; c < this.rows; c++){
                double above = A[r - 1][c];
                A[r][c] -= (a_i * above);
            }
            double d_prime = this.d[r - 1];
            this.d[r] -= (a_i * d_prime);

            double b_i = A[r][r];
            for (int c = r; c < this.rows; c++){
                A[r][c] /= b_i;
            }
            d[r] /= b_i;
        }

        X[rows - 1] = d[rows - 1];
        for(int r = rows - 2; r > -1; r--){
            double res = d[r] - (A[r][r + 1] * X[r + 1] );
            X[r] = res;
        }

        this.confirmAnswer();
        return this.X;
    }

    public static boolean isTridiagonal(double[][] A){
        int n = A.length;
        for (int r = 0; r < n; r++){
            for (int c = r + 2; c < n; c++){
                if (A[r][c] != 0){
                    return false;
                }
            }
        }
        for (int r = 2; r < n; r++){
            for (int c = 0; c < r - 1; c++){
                if (A[r][c] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    private void confirmTridiagonal(){
        System.out.println("Checking if Matrix is tri-diagonal...");
        if (!isTridiagonal(this.A)){
            System.out.println("Matrix A is not tri-diagonal hence cannot be solved using the Thomas Algorithm");
            throw new Error("Matrix A is not tri-diagonal, hence cannot be solved using the Thomas Algorithm");
        }
        System.out.println("Check completed. Valid!");
    }

    public static double[] getResultFromX(double[][] A, double[] X){
        int n = X.length;
        double[] result = new double[n];
        for(int r = 0; r < n; r++){
            double value = 0;
            for (int c = 0; c < n; c++){
                value += (A[r][c] * X[c]);
            }
            result[r] = value;
        }
        System.out.println("Resultant d for AX: " + Arrays.toString(result));
        return result;
    }

    private void confirmAnswer(){
        System.out.println("Checking if final answer is correct... \n");
        double[] finalD = getResultFromX(this.initialA, this.X);
        if(!areEqualArrays(this.initialD, finalD)){
            System.out.println("The answer is not valid, please crosscheck and follow up");
        }
        else{
            System.out.println("The answer is confirmed to be valid!");
        }
    }

    private static boolean areEqualArrays(double[] A, double[] B){
        int n = A.length;
        for (int i = 0; i < n; i++){
            if (A[i] != B[i] && Math.round(A[i]) != Math.round(B[i])){
                System.out.println(A[i] + " != " + B[i]);
                return false;
            }
        }
        return true;
    }
}
