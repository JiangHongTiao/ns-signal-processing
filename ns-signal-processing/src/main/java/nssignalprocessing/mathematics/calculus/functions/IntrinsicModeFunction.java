/*
 * Copyright (C) 2016 xjuraj
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
 * @author xjuraj
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
