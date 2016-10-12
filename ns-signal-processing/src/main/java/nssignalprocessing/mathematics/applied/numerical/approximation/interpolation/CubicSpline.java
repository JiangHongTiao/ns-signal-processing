/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.applied.numerical.approximation.interpolation;

/**
 * Based on: http://www.paulinternet.nl/?page=bicubic and 
 * 
 * @author jurco
 */
public class CubicSpline {

    private double a, b, c, d;                  // cubic coefficients vector

    public CubicSpline(double[][] M, double[] G) {
        a = b = c = d;
        for (int k = 0; k < 4; k++) {  // (a,b,c,d) = M G
            a += M[0][k] * G[k];
            b += M[1][k] * G[k];
            c += M[2][k] * G[k];
            d += M[3][k] * G[k];
        }

    }

    public double eval(double t) {
        return t * (t * (t * a + b) + c) + d;
    }

    public static double onlineEval(double t, double[][] M, double[] G) {
        double as = 0, bs = 0, cs = 0, ds = 0;
        for (int k = 0; k < 4; k++) {  // (a,b,c,d) = M G
            as += M[0][k] * G[k];
            bs += M[1][k] * G[k];
            cs += M[2][k] * G[k];
            ds += M[3][k] * G[k];
        }
        return t * (t * (t * as + bs) + cs) + ds;
    }

    /**
     *
     * @param t poits for which interpolation will be done (output y)
     * @param y X values
     * @param x Y values - have to be sorted inc
     * @param M type of bicubic spline
     * @return
     */
    public static double[] eval(double[] t, int[] x, double[] y, double[][] M) {
        int yi = 0;
        while (x[yi] <= t[0]) {
            yi++; //we get at the beginning of our area of interest
        }
        yi--; //we have to start interval even before
        if (yi < 0 || yi > x.length-2) {
            throw new IllegalArgumentException(String.format("Start index of interpolation "
                    + "is before provided array. You would like to interpolate from: %.3f"
                    + " but first point from which interpolation can be done is: %d", t[0], x[0]));
        }
        double[] result = new double[t.length];
        double as = 0, bs = 0, cs = 0, ds = 0;
        int xm1 = yi - 1, x1 = yi, x2 = yi + 1, x2p1 = yi + 2;
        //boundary conditions
        switch(x.length){
            case 2: xm1 = 0; x1 = 0; x2 = 1; x2p1 = 1; break;
            case 3: xm1 = 0; x1 = 1; x2 = 2; x2p1 = 2; break;
        }
        
        if (yi == 0) {//we do beginning
            xm1 = yi;
        }
        double yFrom = x[yi];
        double yTo = x[yi+1];
        
        as += (M[0][0] * y[xm1]) + (M[0][1] * y[x1]) + (M[0][2] * y[x2]) + (M[0][3] * y[x2p1]);
        bs += (M[1][0] * y[xm1]) + (M[1][1] * y[x1]) + (M[1][2] * y[x2]) + (M[1][3] * y[x2p1]);
        cs += (M[2][0] * y[xm1]) + (M[2][1] * y[x1]) + (M[2][2] * y[x2]) + (M[2][3] * y[x2p1]);
        ds += (M[3][0] * y[xm1]) + (M[3][1] * y[x1]) + (M[3][2] * y[x2]) + (M[3][3] * y[x2p1]);

        for (int ti = 0; ti < t.length; ti++) {
            if (t[ti] > yTo) {//if we are out of interval, we recompute values
                yi++;
                if(yi>=x.length-1){
                    throw new IllegalArgumentException("Line interpolation is out of interpolable area!");
                }
                xm1=x1; x1=x2; x2=x2p1;
                yFrom=x[yi];
                yTo = x[yi+1];
                if(yi==x.length-2){//we do end
                    x2p1=yi+1;
                } else {
                    x2p1=yi+2;
                }
                as = 0; bs = 0; cs = 0; ds = 0;
                as += (M[0][0] * y[xm1]) + (M[0][1] * y[x1]) + (M[0][2] * y[x2]) + (M[0][3] * y[x2p1]);
                bs += (M[1][0] * y[xm1]) + (M[1][1] * y[x1]) + (M[1][2] * y[x2]) + (M[1][3] * y[x2p1]);
                cs += (M[2][0] * y[xm1]) + (M[2][1] * y[x1]) + (M[2][2] * y[x2]) + (M[2][3] * y[x2p1]);
                ds += (M[3][0] * y[xm1]) + (M[3][1] * y[x1]) + (M[3][2] * y[x2]) + (M[3][3] * y[x2p1]);
            }
            double range = yTo-yFrom;
            double tm=(t[ti]-yFrom)/range;
            result[ti] = tm * (tm * (tm * as + bs) + cs) + ds;
        }
        return result;
    }

}
