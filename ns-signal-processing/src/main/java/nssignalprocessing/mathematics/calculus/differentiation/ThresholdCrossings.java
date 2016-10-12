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
package nssignalprocessing.mathematics.calculus.differentiation;

/**
 *
 * @author xjuraj
 */
public class ThresholdCrossings {
    
    /**
     * Count number of zero crossings of discrete function. 
     * @param array array where number of zero crossings to count
     * @param from starting index in array (inclusive)
     * @param to end index in array (exclusive)
     * @return number of times function has crossed zero. All NaN values are ignored 
     * and when input function has value 0 it is not counted as zero crossing. 
     * E.g. for array: [-2,-3, Float.NaN, 7, Float.NaN, 0, 0, 4] function returns 1
     */
    public static int zeroCrossingsCount(double[] array, int from, int to){
        int count = 0;
        double currentSign = Math.signum(array[from]);
        double lastSign = currentSign;
        for (int i = from+1; i < to; i++) {
            currentSign = Math.signum(array[i]);
//            System.out.println(String.format("I: %2d\t#%2d\tC: %2d\tL: %2d\t(%2d)", i, count,(int)currentSign, (int)lastSign, (int)array[i]));
            if(currentSign != lastSign && currentSign != 0 && !Double.isNaN(currentSign)){
                count++;
                lastSign=currentSign;
            }
        }
        return count;
    }
    
    /**
     * Count number of threshold crossings of discrete function. 
     * @param array array where number of threshold crossings to count
     * @param from starting index in array (inclusive)
     * @param to end index in array (exclusive)
     * @param threshold threshold you want to count it for
     * @return number of times function has crossed threshold value. All NaN values are ignored 
     * and when input function has exactly threshold value it is not counted as threshold value crossing.
     */
    public static int count(double[] array, int from, int to, float threshold){
        int count = 0;
        double currentSign = Math.signum(array[from]-threshold);
        double lastSign = currentSign;
        for (int i = from+1; i < to; i++) {
            currentSign = Math.signum(array[i]-threshold);
            if(currentSign != lastSign && currentSign != 0 && !Double.isNaN(currentSign)){
                count++;
                lastSign=currentSign;
            }
        }
        return count;
    }
}
