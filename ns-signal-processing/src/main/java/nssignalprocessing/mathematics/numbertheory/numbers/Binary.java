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
package nssignalprocessing.mathematics.numbertheory.numbers;

/**
 * Implementing fast binary operation with numbers. For some functions it seems 
 * they are defined duplicitly or without too much added information, but with
 * different functions needs you may get better application performance. 
 * @author xjuraj
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
