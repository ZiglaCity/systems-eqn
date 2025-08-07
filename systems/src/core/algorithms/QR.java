package core.algorithms;

import core.utils.Utils;

public class QR {
    public double[][] A;
    public int rows;
    private double[][] Q;
    private double[][] R;

    public QR (double[][] A){
        checkNbyN(A);
        this.A = A;
    }

    public void QRmethod(){
        double[][][] qr = getQR(this.A);
        this.Q = qr[0];
        this.R = qr[1];

        double[][] A_i = getSimilarA(this.Q, this.R);

        if( !confirmQRequalsA(Q, R)){
            System.out.println("Slight inconsistencies with QR != A...");
        }
        this.A = Utils.cloneMatrix(A_i);
        double[][] temp;
        temp = Utils.cloneMatrix(this.Q);
        this.Q = Utils.cloneMatrix(this.R);
        this.R = Utils.cloneMatrix(temp);
    }

    public double[][][] getQR(double[][] A){

    }

    public double[][] getSimilarA(double[][] Q, double[][] R){

    }

    public boolean confirmQRequalsA(double[][] Q, double[][] R){

        return true;
    }



    public void checkNbyN(double[][] A){
        if(A.length != A[0].length){
            System.out.println("THe given matrix A is not an N by N matrix");
            throw new Error("Different row and column sizes in matrix");
        }
        this.rows = A.length;
    }
}
