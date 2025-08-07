package core.algorithms;
import core.algorithms.Matrix;
import java.util.Arrays;

public class ThePowerMethods {
    public double[][] A;
    private double[][] initialA;
    public double[] B;
    public double[] X;
    private final int rows;
    private double largestEigenValue;
    private double[] largestEigenVector;
    private double smallestEigenValue;
    private double[] smallestEigenVector;
    private double eigenValue;
    private double[] eigenVector;

    public ThePowerMethods(double[][] A, double[] X, double[] B){
        if(A[0].length != X.length){
            throw new Error("Matrix A and X are not compatible");
        }
        this.A = A;
        this.X = X;
        if(B != null){
            this.B = B;
        }
        this.rows = A.length;
        this.B = new double[rows];
    }

    public void DirectMethod(int iterations){
//        AX = yX

        int i = iterations;
        double[] prevX = X.clone();
        double largest = 0;
        while(i-- > 0){
            double[] nextX = Matrix.MatrixMultiplication(A, prevX);
            System.out.println(Arrays.toString(nextX));
            largest = Matrix.getMax(nextX);
            for (int j = 0; j < rows; j++){
//          first make sure largest is not zero;
                nextX[j] /= largest;
            }
            prevX = nextX;
        }
        this.largestEigenValue = largest;
        this.largestEigenVector = prevX;
    }

    public static void InverseMethod(){
//    before doing this i need to finish the inverse matrix in the Matrix class, and bro.....!
    }

    public static void EigenMethod(){
//        bro, i need to be working with some quadratics and exponential variables here, i think i'll come back later.
    }

    public double getLargestEigenValue(){
        return this.largestEigenValue;
    }

    public double getSmallestEigenValue(){
        return this.smallestEigenValue;
    }

    public double[] getLargestEigenVector(){
        return this.largestEigenVector;
    }

    public double[] getSmallestEigenVector(){
        return this.smallestEigenVector;
    }

    public double getEigenValue(){
        return this.eigenValue;
    }

    public double[] getEigenVector(){
        return this.eigenVector;
    }

    public boolean confirmLargestEigenValueAndVector(){
        double[] AX = Matrix.MatrixMultiplication(this.A, this.largestEigenVector);
        double[] YX = new double[rows];

        for(int i = 0; i < rows; i++){
            YX[i] = this.largestEigenValue * this.largestEigenVector[i];
        }

        System.out.println("AX: " + Arrays.toString(AX));
        System.out.println("YX: " + Arrays.toString(YX));

        for(int i = 0; i < rows; i++){
            if(AX[i] != YX[i] && Math.round(AX[i]) != Math.round(YX[i])){
                System.out.println("Final largest eigen value seems not to be right please crosscheck");
                return false;
            }
        }
        System.out.println("Final eigen value and vector confirmed to be right... Kudos Zigla!!");
        return true;
    }

}
