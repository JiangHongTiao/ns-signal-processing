/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.calculus.integraltransform.general;

/**
 *
 * @author jurco
 */
public interface Fourier {
    
    public float[][] fft(float[] real);
    public float[][] fft(float[][] complex);
    
    public double[][] fft(double[] real);
    public double[][] fft(double[][] complex);
    
    public float[][] ifft(float[][] complex);
    public double[][] ifft(double[][] complex);
}
