package core.algorithms;

import core.utils.Utils;

public class QR {
    public double[][] A;
    public int rows;
    private double[][] Q;
    private double[][] R;
    public double[] eigenValues;

    public QR (double[][] A){
        checkNbyN(A);
        this.A = A;
    }

    public void QRmethod(){
        int i = 0;
        while (!RisTridiagonalOrCloser(R)) {
            double[][][] qr = getQR(this.A);
            this.Q = qr[0];
            this.R = qr[1];

            if (!confirmQRequalsA(Q, R)) {
                System.out.println("Slight inconsistencies with QR != A...");
            }
            double[][] temp;
            temp = Utils.cloneMatrix(this.Q);
            this.Q = Utils.cloneMatrix(this.R);
            this.R = Utils.cloneMatrix(temp);

            double[][] A_i = getSimilarA(this.Q, this.R);
            this.A = Utils.cloneMatrix(A_i);
            i++;
        }

        extractEigenValues();
    }

    public double[][][] getQR(double[][] A){

    }

    public double[][] getSimilarA(double[][] Q, double[][] R){

    }

    public boolean RisTridiagonalOrCloser(double[][] R){
//        check how close r is to being a tridiagonal
        return false;
    }

    public boolean confirmQRequalsA(double[][] Q, double[][] R){
        double[][] finalA = Matrix.MatrixMultiplication(Q, R);
        if (!Matrix.isIdenticalMatrix(finalA, A)){
            System.out.println("The product of QR does not give A");
            return false;
        }
        return true;
    }

    public void extractEigenValues(){
        for (int i = 0; i < rows; i++){
            eigenValues[i] = R[i][i];
        }
    }

    public double[] getEigenValues() {
        return eigenValues;
    }

    public void checkNbyN(double[][] A){
        if(A.length != A[0].length){
            System.out.println("THe given matrix A is not an N by N matrix");
            throw new Error("Different row and column sizes in matrix");
        }
        this.rows = A.length;
    }
}
