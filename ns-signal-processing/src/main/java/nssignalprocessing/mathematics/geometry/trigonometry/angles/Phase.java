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
package nssignalprocessing.mathematics.geometry.trigonometry.angles;

/**
 *
 * @author xjuraj
 */
public class Phase {
    
    /**
     * Return phase angle for given complex number.
     * @param real real part of the complex number
     * @param imag imaginary part of the complex number
     * @return phase angle of the 
     */
    public static double angle(double real, double imag){
        return Math.atan2(imag, real);
    }
    
}
