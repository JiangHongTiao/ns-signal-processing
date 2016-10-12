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
package nssignalprocessing.mathematics.calculus.incdec;

/**
 *
 * @author xjura
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
