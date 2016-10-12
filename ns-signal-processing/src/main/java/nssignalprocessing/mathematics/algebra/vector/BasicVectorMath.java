/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.algebra.vector;

/**
 *
 * @author jurco
 */
public class BasicVectorMath {
    
    /**
     * Vector addition is the operation of adding two or more vectors together into a vector sum.
     * The so-called parallelogram law gives the rule for vector addition of two or more vectors. 
     * For two vectors A and B, the vector sum A+B is obtained by placing them head to tail and 
     * drawing the vector from the free tail to the free head. In Cartesian coordinates, vector 
     * addition can be performed simply by adding the corresponding components of the vectors, 
     * so if A=(a_1,a_2,...,a_n) and B=(b_1,b_2,...,b_n),
     * A+B=(a_1+b_1,a_2+b_2,...,a_n+b_n). 
     * @param a first vector
     * @param b second vector
     * @return sum of vectors A and B
     */
    public static float[] sum(float[] a, float[] b){
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i]+b[i];
        }
        return result;
    }
    
    public static float[] sum(float[] a, float constValue){
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] + constValue;
        }
        return result;
    }
    
    public static float[] distract(float[] a, float[] b){
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i]-b[i];
        }
        return result;
    }
    
    public static float[] distract(float[] a, float constValue){
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i]- constValue;
        }
        return result;
    }
    
    public static float[] multiply(float[] a, float[] b){
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i]*b[i];
        }
        return result;
    }
    
    public static float[] multiply(float[] a, float constValue){
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i]* constValue;
        }
        return result;
    }
    
    public static float[] divide(float[] a, float[] b){
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i]/b[i];
        }
        return result;
    }
    
    public static float[] divide(float[] a, float constValue){
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i]/constValue;
        }
        return result;
    }
    
    public static float[] pow(float[] a, double pow){
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = (float)Math.pow(a[i], pow);
        }
        return result;
    }
}
