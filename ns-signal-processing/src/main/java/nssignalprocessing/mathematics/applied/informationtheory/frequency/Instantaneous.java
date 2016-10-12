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
package nssignalprocessing.mathematics.applied.informationtheory.frequency;

import nssignalprocessing.mathematics.geometry.trigonometry.angles.Phase;

/**
 *
 * @author xjuraj
 */
public class Instantaneous {
    
    
    /**
     * Compute instantenous frequency from analytical signal.
     * @param real real part of the analytic signal
     * @param imag imaginary part of the analytic signal
     * @param fs sampling frequency
     * @return array of instantenous frequency values
     */
    public double[] freq(double[] real, double[] imag, double fs){
        double f=fs/(2.0*Math.PI);
        double pAng=Phase.angle(real[0], imag[0]);
        double[] result = new double[real.length-1];
        for (int i = 1; i < real.length; i++) {
            double ang=Phase.angle(real[i], imag[i]);
            result[i-1] = f*(pAng-ang);
            pAng=ang;
        }
        return result;
    }
}
