/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.geometry.trigonometry.angles;

/**
 *
 * @author jurco
 */
public class Phase {
    
    /**
     * Return phase angle for given complex number.
     * @param real real part of the complex number
     * @param imag imaginary part of the complex number
     * @return phase angle of the 
     */
    public static double angle(double real, double imag){
        return Math.atan2(imag, real);
    }
    
}
