/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.calculus.incdec;

/**
 *
 * @author jurco
 */
public class MonotonicFunction {
    
    /**
     * A function is monotonic if its first derivative (which need not be continuous) does not change sign.
     * @param array array/discrete function values to check
     * @param from starting point (inclusive)
     * @param to end point (exclusive)
     * @return true if function is monotonic, false otherwise
     * @throws IllegalArgumentException when 'from' parameter is greater or equal to 'to' parameter
     */
    public static boolean isMonotonic(float[] array, int from, int to){
        if(to-from<=0) 
            throw new IllegalArgumentException("'To' parameter is greater or equal 'From' parameter.");
        if(to-from<=2) return true; //no time to change sign
        byte sign=0;
        int idx=from;
        //we look for the first non-zero difference. Till that time function is constant, so monotonic.
        for(; idx<to-1; idx++){
            sign=(byte)Math.signum(array[idx+1]-array[idx]);
            if(sign !=0)break;
        }
        for (; idx < to-1; idx++) {
            byte newSign=(byte)Math.signum(array[idx+1]-array[idx]);
            if((sign^newSign) < -1) return false;
        }     
        return true;
    }
    
    /**
     * A function is monotonic if its first derivative (which need not be continuous) does not change sign.
     * @param array array/discrete function values to check
     * @return true if function is monotonic, false otherwise
     */
    public static boolean isMonotonic(float[] array){
        return isMonotonic(array, 0, array.length);
    }
    
    /**
     * A function is monotonic if its first derivative (which need not be continuous) does not change sign.
     * @param array array/discrete function values to check
     * @param from starting point (inclusive)
     * @param to end point (exclusive)
     * @return true if function is monotonic, false otherwise
     * @throws IllegalArgumentException when 'from' parameter is greater or equal to 'to' parameter
     */
    public static boolean isMonotonic(double[] array, int from, int to){
        if(to-from<=0) 
            throw new IllegalArgumentException("'To' parameter is greater or equal 'From' parameter.");
        if(to-from<=2) return true; //no time to change sign
        byte sign=0;
        int idx=from;
        //we look for the first non-zero difference. Till that time function is constant, so monotonic.
        for(; idx<to-1; idx++){
            sign=(byte)Math.signum(array[idx+1]-array[idx]);
            if(sign !=0)break;
        }
        for (; idx < to-1; idx++) {
            byte newSign=(byte)Math.signum(array[idx+1]-array[idx]);
            if((sign^newSign) < -1) return false;
        }     
        return true;
    }
    
    /**
     * A function is monotonic if its first derivative (which need not be continuous) does not change sign.
     * @param array array/discrete function values to check
     * @return true if function is monotonic, false otherwise
     */
    public static boolean isMonotonic(double[] array){
        return isMonotonic(array, 0, array.length);
    }
}
