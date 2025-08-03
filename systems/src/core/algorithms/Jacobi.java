package core.algorithms;

import core.utils.Utils;

import java.rmi.server.UID;
import java.util.Arrays;

public class Jacobi {
    private final double[][] A;
    private final double[] d;
    public double[][] initialA;
    public double[] initialD;
    private double[] X;
    private final int rows;

    public Jacobi (double[][] A, double[] d, double[]  initialX){
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
        if(initialX != null){
            if(initialX.length != rows){
                System.out.println("Value for Initial X is invalid");
                throw new Error("Initial X is invalid!");
            }
            this.X = initialX;
        }
        else this.X = new double[rows];
    }

    public double[] JocobiAlgorithm(int iterations){

        int i = iterations;
        double[] prevX = X.clone();
        Utils.toString(A);
        Utils.toString(prevX);
        Utils.toString(d);
        while(i-- > 0){
            double[] currentX = prevX.clone();
            System.out.println("Current X: " + Arrays.toString(currentX));
            for(int r = 0; r < rows; r++){
                System.out.println("X_"+r);
                double value = 0;
                for(int c = 0; c < rows; c++){
                    if(c != r){
                        value += (A[r][c] * currentX[c]);
                        System.out.println("Value: "+ value);
                    }
                }
                prevX[r] = (d[r] - value) / A[r][r];
            }
            System.out.println("Current X state after " + (iterations - i) + " iterations");
            System.out.println(Arrays.toString(prevX));
            this.X = prevX;
            isAnswerCLoseOrCorrect();
        }
        return prevX;
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

    private boolean isAnswerCLoseOrCorrect(){
        System.out.println("Checking if final answer is correct... \n");
        double[] finalD = getResultFromX(this.initialA, this.X);
        if(areEqualArrays(finalD, initialD) || areAlmostEqualArrays(finalD, initialD)){
            System.out.println("The answer is confirmed to be valid!");
        }
        else{
            System.out.println("The answer is not valid, please crosscheck and follow up");
        }
        return areEqualArrays(finalD, initialD) || areAlmostEqualArrays(finalD, initialD);
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

    public static boolean areAlmostEqualArrays(double[] A, double[] B){
//        here determine if the 2 arrays are almost the same...
        return false;
    }

}
