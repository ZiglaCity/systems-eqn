package core.algorithms;

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

    public static void DirectMethod(){

    }

    public static void InverseMethod(){

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

}
