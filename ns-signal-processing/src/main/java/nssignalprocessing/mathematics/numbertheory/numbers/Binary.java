/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.numbertheory.numbers;

/**
 * Implementing fast binary operation with numbers. For some functions it seems 
 * they are defined duplicitly or without too much added information, but with
 * different functions needs you may get better application performance. 
 * @author jurco
 */
public class Binary {
    
    public static double LOG_2 = Math.log(2);
    
    /**
     * Check whether number is power of two with complexity 3 operations: x != (x & -x);
     * @param x number to check.
     * @return true in the case that number is not equal to any integer power of two.
     */
    public static boolean isPow2(long x) {
        return x == (x & -x);
    }
    
    /**
     * Check whether number is power of two with complexity 3 operations: x == (x & -x);
     * @param x number to check.
     * @return true in the case that number is equal to some integer power of two.
     */
    public static boolean isNotPow2(long x) {
        return x != (x & -x);
    }
    
    public static int ceilPow2(long x) {
        return 1<<(int)Math.ceil(Math.log(x)/LOG_2);
    }
    
    public static int floorPow2(long x) {
        return 1<<(int)Math.floor(Math.log(x)/LOG_2);
    }
    
    
}
