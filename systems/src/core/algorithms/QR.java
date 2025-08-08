package core.algorithms;

import core.utils.Utils;
import jdk.jshell.execution.Util;

import java.util.Arrays;

public class QR {
    public double[][] A;
    public int rows;
    private double[][] Q;
    private double[][] R;
    public double[] eigenValues;
    public double precision = 0.0001;

    public QR (double[][] A){
        checkNbyN(A);
        this.A = A;
        this.rows = A.length;
        this.Q = new double[rows][rows];
        this.R = new double[rows][rows];
        this.eigenValues = new double[rows];
    }

    public void QRmethod(int iterator){
        int i = 0;
        while (i < iterator) {
            System.out.println("Iteration: "+i);
            double[][][] qr = getQR(this.A);
            this.Q = qr[0];
            this.R = qr[1];

            if (!confirmQRequalsA(Q, R)) {
                System.out.println("Slight inconsistencies with QR != A... at Iteration: "+i);
            }
//            double[][] temp;
//            temp = Utils.cloneMatrix(this.Q);
//            this.Q = Utils.cloneMatrix(this.R);
//            this.R = Utils.cloneMatrix(temp);

            double[][] A_i = getSimilarA(this.Q, this.R);
//             Utils.toString(Q);
//             Utils.toString(R);

            this.A = Utils.cloneMatrix(A_i);
            i++;
            if(RisUpperDiagonalOrCloser(A)){
                break;
            }
        }

        extractEigenValues();
    }

    public double[][][] getQR(double[][] A){

//        using the a columns, a1, a2, a3, ... an
//        first get q1, which is a / [[ a ]]
//        get the a_primes as ai - Sum( (qTk . ai ). qk); where k = [1: i - 1]
//        get the q columns from  a_prime / [[ a_prime ]]
//        the diagonal r values area always [[ a_prime ]]
//        the individual r values, i.e r(i, j) = qi . aj, which is gotten right from the calculation of the a_primes

        double[][] AinCols = Matrix.Transpose(A);
        double[][] QinCols = new double[rows][rows];
        double len_a1 = Matrix.Magnitude(AinCols[0]);
        double[] q1 = new double[rows];

        for (int i = 0; i < rows; i++){
            q1[i] = AinCols[0][i]/len_a1;
        }

        QinCols[0] = q1;
        double[][] R_i = new double[rows][rows];
        R_i[0][0] = len_a1;

        for(int r = 1; r < rows; r++){
            double[] ai_sum = new double[rows];
            System.out.println("\nFor a"+r);
            System.out.println("Solving for q"+r +"\n");
             for (int k = 0; k < r; k++){
                 double[] qTk = QinCols[k];
                 System.out.println("k = " + k + " r = " + r);
                 double qTk_ai = Matrix.MatrixMultiplication(qTk, AinCols[r]);
                 System.out.println("The product of q"+k+ " and " + "a"+r + " == " + qTk_ai + " This becomes r" +k+","+r);
                 R_i[k][r] = qTk_ai;
                 double[] qTk_ai_qk = new double[rows];
                 for (int i = 0; i < rows; i++){
                     qTk_ai_qk[i] = qTk_ai * QinCols[k][i];
                 }
                 System.out.println("(qT"+k+ " * a"+r+") * q"+k + " == "+ Arrays.toString(qTk_ai_qk));
                 ai_sum = Matrix.MatrixAddition(ai_sum, qTk_ai_qk);
                 System.out.println("Current Summation of (qTk . ai) . qk == " + Arrays.toString(ai_sum));
             }
             double[] ai_prime = Matrix.MatrixSubtraction(AinCols[r], ai_sum);
             System.out.println("a"+r+ "` == " + Arrays.toString(ai_prime));

            double len_ai = Matrix.Magnitude(ai_prime);
            double[] qi = new double[rows];
            for (int i = 0; i < rows; i++){
                qi[i] = ai_prime[i]/len_ai;
            }
            System.out.println("q"+r +  " == "+ Arrays.toString(qi));
            QinCols[r] = qi;
            R_i[r][r] = len_ai;
        }
        double[][] Q_i = Matrix.Transpose(QinCols);
        double[][][] res = new double[2][][];
        res[0] = Utils.cloneMatrix(Q_i);
        res[1] = R_i;
        Utils.toString(res[0]);
        Utils.toString(res[1]);
        return res;
    }

    public double[][] getSimilarA(double[][] Q, double[][] R){
//        a nww A, = RQ is obtained...
        return Matrix.MatrixMultiplication(R, Q);
    }

    public boolean RisUpperDiagonalOrCloser(double[][] R){
//        check how close r is to being a UpperDiagonal
        for (int r= 1; r < rows; r++){
            for (int c = 0; c < r; c++){
                if(R[r][c] > precision){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean confirmQRequalsA(double[][] Q, double[][] R){
        double[][] finalA = Matrix.MatrixMultiplication(Q, R);
        if (!Matrix.isIdenticalMatrix(finalA, A)){
            System.out.println("The product of QR does not give A");
            return false;
        }
        System.out.println("Final A after QR");
        Utils.toString(finalA);
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

    public void setPrecision(double precision){
        this.precision = precision;
    }
}
