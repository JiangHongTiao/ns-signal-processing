/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.calculus.minmax;

import java.util.LinkedList;
import java.util.List;
import nssignalprocessing.utils.Arrays;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author jurco
 */
public class Maxima {
    
    /**
     * Find all maxima in the array and return all indexes where local maxima occurs.
     * @param array array where all maxima should be checked
     * @param from start index (included, but maxima not checked for this)
     * @param to (excluded, maxima not checked also for to-1)
     * @return indexes of all local maxima in the given interval. 
     */
    public static int[] getAllMaximaIndexes(int[] array, int from, int to){
        //because just of adding and final conversion into array
        List<Integer> result = new LinkedList<>();
        //were last two values increasing?
        boolean isInc = array[from] < array[from+1];
        //even if at the beginning are two equal values, because we do not know 
        //whether it was decreasing or increasing
        int zeroIndex=-1;
        int am1, a, ap1;
        for (int i = from+1; i < to-1; i++) {
            am1 = array[i-1];
            a=array[i];
            ap1=array[i+1];
            if(isInc && a == ap1 && am1!=a) zeroIndex=i; //only when it was increasing before
            if(isInc && am1==a && ap1<a)result.add(zeroIndex);
            if(am1 < a && a > ap1) result.add(i);
            if(a != ap1) isInc=a<ap1;//update only when there is no stagnation
        }
        return Arrays.listToPrimitive(result);
    }
    
    /**
     * Find all maxima in the array and return all indexes where local maxima occurs.
     * @param array array where all maxima should be checked
     * @param from start index (included, but maxima not checked for this)
     * @param to (excluded, maxima not checked also for to-1)
     * @return indexes of all local maxima in the given interval. 
     */
    public static int[] getAllMaximaIndexes(double[] array, int from, int to){
        //because just of adding and final conversion into array
        List<Integer> result = new LinkedList<>();
        //were last two values increasing?
        boolean isInc = array[from] < array[from+1];
        //even if at the beginning are two equal values, because we do not know 
        //whether it was decreasing or increasing
        int zeroIndex=-1;
        double am1, a, ap1;
        for (int i = from+1; i < to-1; i++) {
            am1 = array[i-1];
            a=array[i];
            ap1=array[i+1];
            if(isInc && a == ap1 && am1!=a) zeroIndex=i; //only when it was increasing before
            if(isInc && am1==a && ap1<a)result.add(zeroIndex);
            if(am1 < a && a > ap1) result.add(i);
            if(a != ap1) isInc=a<ap1;//update only when there is no stagnation
        }
        return Arrays.listToPrimitive(result);
    }
    
    /**
     * Find all maxima in the array and return all indexes where local maxima occurs.
     * @param array array where all maxima should be checked
     * @param from start index (included, but maxima not checked for this)
     * @param to (excluded, maxima not checked also for to-1)
     * @return indexes of all local maxima in the given interval. 
     */
    public static Pair<int[], double[]> getAllMaximaWithIndexes(double[] array, int from, int to){
        //because just of adding and final conversion into array
        int incConstant = 8;
        int range=to-from;
        int incSize = Math.max(incConstant, range/incConstant);
        
        int[] rIdx = new int[incSize];
        double[] rVal = new double[incSize];
        int cId = 0;
        
        //were last two values increasing?
        boolean isInc = array[from] < array[from+1];
        //even if at the beginning are two equal values, because we do not know 
        //whether it was decreasing or increasing
        int zeroIndex=-1;
        double am1, a, ap1;
        for (int i = from+1; i < to-1; i++) {
            am1 = array[i-1];
            a=array[i];
            ap1=array[i+1];
            if(isInc && a == ap1 && am1!=a) zeroIndex=i; //only when it was increasing before
            if(isInc && am1==a && ap1<a){
                rIdx[cId] = zeroIndex;
                rVal[cId] = array[zeroIndex];
                cId++;
            }
            if(am1 < a && a > ap1){
                rIdx[cId] = i;
                rVal[cId] = array[i];
                cId++;
            }
            if(a != ap1) isInc=a<ap1;//update only when there is no stagnation
            if(cId == rIdx.length){
                range=to-i;
                incSize = Math.max(incConstant, range/incConstant);
                rIdx=java.util.Arrays.copyOf(rIdx, rIdx.length+incSize);
                rVal=java.util.Arrays.copyOf(rVal, rIdx.length+incSize);
            }
        }
        return new ImmutablePair<>(
                java.util.Arrays.copyOf(rIdx, cId),
                java.util.Arrays.copyOf(rVal, cId)
        );
    }
    
    public static Pair<int[], double[]> getAllMaximaWithIndexes(double[] array){
        return getAllMaximaWithIndexes(array, 0, array.length);
    }
    
}
