/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.applied.informationtheory.frequency;

import nssignalprocessing.mathematics.geometry.trigonometry.angles.Phase;

/**
 *
 * @author jurco
 */
public class Instantaneous {
    
    
    /**
     * Compute instantenous frequency from analytical signal.
     * @param real real part of the analytic signal
     * @param imag imaginary part of the analytic signal
     * @param fs sampling frequency
     * @return array of instantenous frequency values
     */
    public double[] freq(double[] real, double[] imag, double fs){
        double f=fs/(2.0*Math.PI);
        double pAng=Phase.angle(real[0], imag[0]);
        double[] result = new double[real.length-1];
        for (int i = 1; i < real.length; i++) {
            double ang=Phase.angle(real[i], imag[i]);
            result[i-1] = f*(pAng-ang);
            pAng=ang;
        }
        return result;
    }
}
