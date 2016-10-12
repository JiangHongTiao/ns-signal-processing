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
package nssignalprocessing.mathematics.calculus.minmax;

import java.util.LinkedList;
import java.util.List;
import nssignalprocessing.utils.Arrays;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author xjuraj
 */
public class Minima {
    
    /**
     * Find all minima in the array and return all indexes where local minima occurs.
     * @param array array where all minima should be checked
     * @param from start index (included, but minima not checked for this)
     * @param to (excluded, minima not checked also for to-1)
     * @return indexes of all local minima in the given interval. 
     */
    public static int[] getAllMinimaIndexes(double[] array, int from, int to){
        //because just of adding and final conversion into array
        List<Integer> result = new LinkedList<>();
        //were last two values decreasing?
        boolean isDec = array[from] > array[from+1];
        //even if at the beginning are two equal values, because we do not know 
        //whether it was decreasing or increasing
        int zeroIndex=-1;
        double am1, a, ap1;
        for (int i = from+1; i < to-1; i++) {
            am1 = array[i-1];
            a=array[i];
            ap1=array[i+1];
            if(isDec && a == ap1 && am1!=a) zeroIndex=i; //only when it was decreasing before
            if(isDec && am1==a && ap1>a)result.add(zeroIndex);
            if(am1 > a && a < ap1) result.add(i);
            if(a != ap1) isDec=a>ap1;//update only when there is no stagnation
        }
        return Arrays.listToPrimitive(result);
    }
    
    /**
     * Find all minima in the array and return all indexes where local minima occurs.
     * @param array array where all minima should be checked
     * @param from start index (included, but minima not checked for this)
     * @param to (excluded, minima not checked also for to-1)
     * @return indexes of all local minima in the given interval. 
     */
    public static int[] getAllMinimaIndexes(int[] array, int from, int to){
        //because just of adding and final conversion into array
        List<Integer> result = new LinkedList<>();
        //were last two values decreasing?
        boolean isDec = array[from] > array[from+1];
        //even if at the beginning are two equal values, because we do not know 
        //whether it was decreasing or increasing
        int zeroIndex=-1;
        int am1, a, ap1;
        for (int i = from+1; i < to-1; i++) {
            am1 = array[i-1];
            a=array[i];
            ap1=array[i+1];
            if(isDec && a == ap1 && am1!=a) zeroIndex=i; //only when it was decreasing before
            if(isDec && am1==a && ap1>a)result.add(zeroIndex);
            if(am1 > a && a < ap1) result.add(i);
            if(a != ap1) isDec=a>ap1;//update only when there is no stagnation
        }
        return Arrays.listToPrimitive(result);
    }
    
    /**
     * Find all minima in the array and return all indexes where local minima occurs.
     * @param array array where all minima should be checked
     * @param from start index (included, but minima not checked for this)
     * @param to (excluded, minima not checked also for to-1)
     * @return indexes of all local minima in the given interval. 
     */
    public static Pair<int[], double[]> getAllMinimaWithIndexes(double[] array, int from, int to){
        //because just of adding and final conversion into array
        int incConstant = 8;
        int range=to-from;
        int incSize = Math.max(incConstant, range/incConstant);
        
        int[] rIdx = new int[incSize];
        double[] rVal = new double[incSize];
        int cId = 0;
        
        //were last two values increasing?
        boolean isDec = array[from] > array[from+1];
        //even if at the beginning are two equal values, because we do not know 
        //whether it was decreasing or increasing
        int zeroIndex=-1;
        double am1, a, ap1;
        for (int i = from+1; i < to-1; i++) {
            am1 = array[i-1];
            a=array[i];
            ap1=array[i+1];
            if(isDec && a == ap1 && am1!=a) zeroIndex=i; //only when it was increasing before
            if(isDec && am1==a && ap1>a){
                rIdx[cId] = zeroIndex;
                rVal[cId] = array[zeroIndex];
                cId++;
            }
            if(am1 > a && a < ap1){
                rIdx[cId] = i;
                rVal[cId] = array[i];
                cId++;
            }
            if(a != ap1) isDec=a>ap1;//update only when there is no stagnation
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
    
    public static Pair<int[], double[]> getAllMinimaWithIndexes(double[] array){
        return getAllMinimaWithIndexes(array, 0, array.length);
    }
    
}
