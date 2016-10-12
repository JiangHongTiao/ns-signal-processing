/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.utils;

import java.util.List;

/**
 *
 * @author jurco
 */
public class Arrays {
    
    /**
     * Transform list of Integers into primitive array type int[].
     * @param source source list
     * @return elements of the list transformed into array. Order of elements is preserved.
     */
    public static int[] listToPrimitive(List<Integer> source){
        int[] result = new int[source.size()];
        for (int i = 0; i < source.size(); i++) {
            result[i] = source.get(i);
        }
        return result;
    }
}
