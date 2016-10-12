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
package nssignalprocessing.mathematics.geometry.linegeometry.ranges;

/**
 *
 * @author xjuraj
 */
public class Intervals {
    
    /**
     * Check whether two intervals are overlapping or not. Border values of intervals are exclusive. 
     * @param fromA beginning of the first interval
     * @param toA end of the first interval
     * @param fromB beginning of the second interval
     * @param toB end of the second interval
     * @return true if specified intervals are overlapping. false otherwise. 
     */
    public static boolean overlaps(int fromA, int toA, int fromB, int toB){
        return (fromA<toB)&&(fromB<toA);
    }
    
}
