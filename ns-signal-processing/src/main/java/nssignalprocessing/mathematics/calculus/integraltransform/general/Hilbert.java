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
public class Hilbert {
    
    private final Fourier f;

    public Hilbert() {
        f = new FourierSTP();
    }

    public Hilbert(Fourier f) {
        this.f = f;
    }
    
    /**
     * Create analytical signal out of real by Hilbert transform.
     * @param real real signal
     * @return Analytical signal as output of hilbert transform.
     */
    public float[][] analytic(float[] real){
        return analyticFromSpectrum(f.fft(real));
    }
    
    /**
     * Create analytical signal out of Fourier spectrum.
     * @param spectrum signal spectrum
     * @return Analytical signal as output of hilbert transform.
     */
    public float[][] analyticFromSpectrum(float[][] spectrum){
        int n=spectrum[0].length;
        int half=n/2;
        
        for (int i = 1; i < half; i++) {
            spectrum[0][i] *= 2.0;
            spectrum[1][i] *= 2.0;
        }
        for (int i = half+1; i < n; i++) {
            spectrum[0][i] = 0.0f;
            spectrum[1][i] = 0.0f;
        }
        return f.ifft(spectrum);
    }
    
    /**
     * Create analytical signal out of real by Hilbert transform.
     * @param real real signal
     * @return Analytical signal as output of hilbert transform.
     */
    public double[][] analytic(double[] real){
        return analyticFromSpectrum(f.fft(real));
    }
    
    /**
     * Create analytical signal out of Fourier spectrum.
     * @param spectrum signal spectrum
     * @return Analytical signal as output of hilbert transform.
     */
    public double[][] analyticFromSpectrum(double[][] spectrum){
        int n=spectrum[0].length;
        int half=n/2;
        
        for (int i = 1; i < half; i++) {
            spectrum[0][i] *= 2.0;
            spectrum[1][i] *= 2.0;
        }
        for (int i = half+1; i < n; i++) {
            spectrum[0][i] = 0.0f;
            spectrum[1][i] = 0.0f;
        }
        return f.ifft(spectrum);
    }
    
    
}
