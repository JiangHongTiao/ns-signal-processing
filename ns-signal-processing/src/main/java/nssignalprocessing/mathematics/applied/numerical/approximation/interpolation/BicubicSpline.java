/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.applied.numerical.approximation.interpolation;

/**
 *
 * @author jurco
 */
public class BicubicSpline {
    
    public BicubicSpline(double[][] M, double[][] G) {
        for (int i = 0; i < 4; i++) // T = G MT
        {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    T[i][j] += G[i][k] * M[j][k];
                }
            }
        }

        for (int i = 0; i < 4; i++) // C = M T
        {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    C[i][j] += M[i][k] * T[k][j];
                }
            }
        }
    }

    private final double[][] C = new double[4][4];    // bicubic coefficients matrix
    private final double[][] T = new double[4][4];    // scratch matrix
    private final double[] C3 = C[0], C2 = C[1], C1 = C[2], C0 = C[3];

    public double eval(double u, double v) {
        return u * (u * (u * (v * (v * (v * C3[0] + C3[1]) + C3[2]) + C3[3])
                + (v * (v * (v * C2[0] + C2[1]) + C2[2]) + C2[3]))
                + (v * (v * (v * C1[0] + C1[1]) + C1[2]) + C1[3]))
                + (v * (v * (v * C0[0] + C0[1]) + C0[2]) + C0[3]);
    }
    
}
