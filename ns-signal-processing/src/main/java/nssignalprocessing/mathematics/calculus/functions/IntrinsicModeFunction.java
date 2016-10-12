/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.calculus.functions;

import nssignalprocessing.mathematics.calculus.differentiation.ThresholdCrossings;
import nssignalprocessing.mathematics.calculus.minmax.Maxima;
import nssignalprocessing.mathematics.calculus.minmax.Minima;

/**
 *
 * An IMF is defined as a function that satisfies the following requirements:
 * <ol>
 *  <li>In the whole data set, the number of extrema and the number of zero-crossings 
 * must either be equal or differ at most by one.</li>
 *  <li>At any point, the mean value of the envelope defined by the local maxima 
 * and the envelope defined by the local minima is zero.</li>
 * </ol>
 * It represents a generally simple oscillatory mode as a counterpart to the simple 
 * harmonic function. By definition, an IMF is any function with the same number 
 * of extrema and zero crossings, whose envelopes are symmetric with respect to zero. 
 * This definition guarantees a well-behaved Hilbert transform of the IMF.
 * @author jurco
 */
public class IntrinsicModeFunction {
    
    /**
     * Checking if discrete function is Intrinsic Mode Function (IMF) or not. 
     * 
     * An IMF is defined as a function that satisfies the following requirements:
     * <ol>
     *  <li>In the whole data set, the number of extrema and the number of zero-crossings 
     * must either be equal or differ at most by one.</li>
     *  <li>At any point, the mean value of the envelope defined by the local maxima 
     * and the envelope defined by the local minima is zero.</li>
     * </ol>
     * It represents a generally simple oscillatory mode as a counterpart to the simple 
     * harmonic function. By definition, an IMF is any function with the same number 
     * of extrema and zero crossings, whose envelopes are symmetric with respect to zero. 
     * This definition guarantees a well-behaved Hilbert transform of the IMF.
     * @param array discrete function values to check if they meet IMF requirements
     * @param from position in array where to start (included)
     * @param to end index (excluded)
     * @return true if given discrete function values are IMF, false otherwise
     */
    public static boolean isIMF(double[] array, int from, int to){
        int zeroCrossings = ThresholdCrossings.zeroCrossingsCount(array, from, to);
        int[] maxima = Maxima.getAllMaximaIndexes(array, from, to);
        int[] minima = Minima.getAllMinimaIndexes(array, from, to);
        return Math.abs(maxima.length + minima.length-zeroCrossings)<=1;
    }
    
    public static boolean isIMF(double[] array){
        return isIMF(array, 0, array.length);
    }
}
