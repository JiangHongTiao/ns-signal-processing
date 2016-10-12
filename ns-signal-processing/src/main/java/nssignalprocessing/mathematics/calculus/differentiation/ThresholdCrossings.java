/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.calculus.differentiation;

/**
 *
 * @author jurco
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
