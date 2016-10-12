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
package nssignalprocessing.mathematics.calculus.integraltransform.general;

/**
 *
 * @author xjuraj
 */
public interface Fourier {
    
    public float[][] fft(float[] real);
    public float[][] fft(float[][] complex);
    
    public double[][] fft(double[] real);
    public double[][] fft(double[][] complex);
    
    public float[][] ifft(float[][] complex);
    public double[][] ifft(double[][] complex);
}
