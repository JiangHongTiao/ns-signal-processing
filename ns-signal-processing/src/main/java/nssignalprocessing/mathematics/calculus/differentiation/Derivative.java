/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.calculus.differentiation;

/**
 * Computing derivations for discrete arrays.
 * @author jurco
 */
public class Derivative {
    
    /**
     * Compute first derivative of discrete signal.
     * @param array function values to compute first derivative from
     * @param from start index from where to start computing derivatives (inclusive)
     * @param to end index index that will already not be used for computing derivatives. 
     * @return Newly allocated array with computed the first derivatives. Size of 
     * this array will be to-from-1, since for the last value no derivative can be computed.
     */
    public static float[] first(float[] array, int from, int to){
        float[] result = new float[to-from-1];
        firstIntoArray(array, from, to, result, 0);
        return result;
    }
    
    /**
     * Compute first derivative inline of provided array. Use with caution! 
     * It will owerride original data! 
     * @param array function values to compute first derivative from
     * @param from start index from where to start computing derivatives (inclusive)
     * @param to end index index that will already not be used for computing derivatives.
     */
    public static void firstInline(float[] array, int from, int to){
        firstIntoArray(array, from, to, array, from);
    }
    
    /**
     * Compute first derivative and result stores into array provided as another parameter. 
     * This is general implementation of first derivative method emthod. 
     * @param array function values to compute first derivative from
     * @param from start index from where to start computing derivatives (inclusive)
     * @param to end index index that will already not be used for computing derivatives.
     * @param into array where to store results of first derivation
     * @param intoFrom first index from which to start filling results. Size of 
     * the <code>into</code> array has to be at least infoFrom+to-from-1
     */
    public static void firstIntoArray(float[] array, int from, int to, float[] into, int intoFrom){
        for (int i = 0; i < to-from-1; i++) {
            into[intoFrom+i] = array[from+i]-array[from+i+1];
        }
    }
    
    /**
     * Compute second derivative of discrete signal.
     * @param array function values to compute second derivative from
     * @param from start index from where to start computing derivatives (inclusive)
     * @param to end index index that will already not be used for computing derivatives. 
     * @return Newly allocated array with computed the second derivatives. Size of 
     * this array will be to-from-2, since for the last value no derivative can be computed.
     */
    public static float[] second(float[] array, int from, int to){
        float[] result = new float[to-from-2];
        secondIntoArray(array, from, to, result, 0);
        return result;
    }
    
    /**
     * Compute second derivative inline of provided array. Use with caution! 
     * It will owerride original data! 
     * @param array function values to compute second derivative from
     * @param from start index from where to start computing derivatives (inclusive)
     * @param to end index index that will already not be used for computing derivatives.
     */
    public static void secondInline(float[] array, int from, int to){
        secondIntoArray(array, from, to, array, from);
    }
    
    /**
     * Compute second derivative and result stores into array provided as another parameter. 
     * This is general implementation of second derivative method emthod. 
     * @param array function values to compute second derivative from
     * @param from start index from where to start computing derivatives (inclusive)
     * @param to end index index that will already not be used for computing derivatives.
     * @param into array where to store results of second derivation
     * @param intoFrom first index from which to start filling results. Size of 
     * the <code>into</code> array has to be at least infoFrom+to-from-2
     */
    public static void secondIntoArray(float[] array, int from, int to, float[] into, int intoFrom){
        for (int i = 0; i < to-from-2; i++) {
            into[intoFrom+i] = array[from+i]-array[from+i+1]-array[from+i+2];
        }
    }
    
    /**
     * Compute n<pre>th</pre> derivative of discrete signal.
     * @param array function values to compute n<pre>th</pre> derivative from
     * @param from start index from where to start computing derivatives (inclusive)
     * @param to end index index that will already not be used for computing derivatives. 
     * @param n derivative order
     * @return Newly allocated array with computed the n<pre>th</pre> derivatives. Size of 
     * this array will be to-from-n, since for the last value no derivative can be computed.
     */
    public static float[] nth(float[] array, int from, int to, int n){
        float[] result = new float[to-from-n];
        nthIntoArray(array, from, to, n, result, 0);
        return result;
    }
    
    /**
     * Compute n<pre>th</pre> derivative inline of provided array. Use with caution! 
     * It will owerride original data! 
     * @param array function values to compute n<pre>th</pre> derivative from
     * @param from start index from where to start computing derivatives (inclusive)
     * @param to end index index that will already not be used for computing derivatives.
     * @param n derivative order
     */
    public static void nthInline(float[] array, int from, int to, int n){
        nthIntoArray(array, from, to, n, array, from);
    }
    
    /**
     * Compute n<pre>th</pre> derivative and result stores into array provided as another parameter. 
     * This is general implementation of n<pre>th</pre> derivative method emthod. 
     * @param array function values to compute n<pre>th</pre> derivative from
     * @param from start index from where to start computing derivatives (inclusive)
     * @param to end index index that will already not be used for computing derivatives.
     * @param n derivative order
     * @param into array where to store results of n<pre>th</pre> derivation
     * @param intoFrom first index from which to start filling results. Size of 
     * the <code>into</code> array has to be at least infoFrom+to-from-n
     */
    public static void nthIntoArray(float[] array, int from, int to, int n, float[] into, int intoFrom){
        for (int i = 0; i < to-from-n; i++) {
            float nth=array[from+i];
            for (int j = 1; j < n; j++) {
                nth-=array[from+i+j];
            }
            into[intoFrom+i] = nth;
        }
    }
}
