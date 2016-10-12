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

import nssignalprocessing.mathematics.numbertheory.numbers.Binary;
import java.util.Arrays;

/**
 * Single Thread Processor implementation of Fourier Transform
 * @author xjuraj
 */
public class FourierSTP implements Fourier{
    
    
    public double[][] dft(double[] input) {
        int N = input.length;
        double[][] complex = new double[2][N];

        for (int k = 0; k < N; k++) {
            for (int n = 0; n < N; n++) {
                complex[0][k] += input[n] * Math.cos(-2 * Math.PI * k * n / N); // Real
                complex[1][k] += input[n] * Math.sin(-2 * Math.PI * k * n / N); // Imaginary
            }
        }

        return complex;
    }
    
    @Override
    public float[][] fft(float[] real){
        float[][] complex;
        int N = real.length;
        if(Binary.isPow2(N)){
            complex = new float[2][];
            complex[0] = real;
            complex[1] = new float[real.length];
            return fft(complex);
        } else {
            complex = new float[2][Binary.ceilPow2(N)];
            System.arraycopy(real, 0, complex[0], 0, N);
            float[][] result = fft(complex);
            result[0] = Arrays.copyOf(result[0], N);
            result[1] = Arrays.copyOf(result[1], N);
            return result;
        }
    }
    
    @Override
    public float[][] fft(float[][] complex){
        int N = complex[0].length;
        if(Binary.isNotPow2(N)) throw new IllegalArgumentException("Data has to have length of power of two.");

        try {
            int NM1 = N - 1;
            int ND2 = N / 2;

            int M = (int) (Math.log10(N) / Math.log10(2));

            int J = ND2;
            int K;

            for (int I = 1; I <= N - 2; I++) {
                if (I < J) {
                    float TR = complex[0][J];
                    float TI = complex[1][J];

                    complex[0][J] = complex[0][I];
                    complex[1][J] = complex[1][I];

                    complex[0][I] = TR;
                    complex[1][I] = TI;
                }
                K = ND2;
                while (K <= J) {
                    J = J - K;
                    K = K / 2;
                }
                J = J + K;
            }

            for (int L = 1; L <= M; L++) {
                int LE = (int) Math.pow(2, L);
                int LE2 = LE / 2;
                double UR = 1;
                double UI = 0;

                double pod = Math.PI / (double) LE2;

                double SR = Math.cos(pod);
                double SI = -Math.sin(pod); //1330

                double TR;
                double TI;

                for (J = 1; J <= LE2; J++) {
                    int JM1 = J - 1;

                    for (int I = JM1; I <= NM1; I = I + LE) {
                        int IP = I + LE2;

                        TR = complex[0][IP] * (double) UR - complex[1][IP] * (double) UI;
                        TI = complex[0][IP] * (double) UI + complex[1][IP] * (double) UR;
                        complex[0][IP] = (float)(complex[0][I] - TR);
                        complex[1][IP] = (float)(complex[1][I] - TI);
                        complex[0][I] = (float)(complex[0][I] + TR);
                        complex[1][I] = (float)(complex[1][I] + TI);
                    } //1440

                    double TMR = UR;

                    UR = TMR * SR - UI * SI;
                    UI = TMR * SI + UI * SR;

                }
            }
        } catch (Exception e) {
            System.err.println("Exception during FFT computation: " + e.getMessage());
        }

        return complex;
    }
    
    @Override
    public double[][] fft(double[] real) {
        double[][] complex;
        int N = real.length;
        if(Binary.isPow2(N)){
            complex = new double[2][];
            complex[0] = real;
            complex[1] = new double[real.length];
            return fft(complex);
        } else {
            complex = new double[2][Binary.ceilPow2(N)];
            System.arraycopy(real, 0, complex[0], 0, N);
            double[][] result = fft(complex);
            result[0] = Arrays.copyOf(result[0], N);
            result[1] = Arrays.copyOf(result[1], N);
            return result;
        }
    }
    
    @Override
    public double[][] fft(double[][] complex) {
        int N = complex[0].length;
        if(Binary.isNotPow2(N)) throw new IllegalArgumentException("Data has to have length of power of two.");

        try {
            int NM1 = N - 1;
            int ND2 = N / 2;

            int M = (int) (Math.log10(N) / Math.log10(2));

            int J = ND2;
            int K = -1;

            for (int I = 1; I <= N - 2; I++) {
                if (I < J) {
                    double TR = complex[0][J];
                    double TI = complex[1][J];

                    complex[0][J] = complex[0][I];
                    complex[1][J] = complex[1][I];

                    complex[0][I] = TR;
                    complex[1][I] = TI;
                }
                K = ND2;
                while (K <= J) {
                    J = J - K;
                    K = K / 2;
                }
                J = J + K;
            }

            for (int L = 1; L <= M; L++) {
                int LE = (int) Math.pow(2, L);
                int LE2 = LE / 2;
                double UR = 1;
                double UI = 0;

                double pod = Math.PI / (double) LE2;

                double SR = Math.cos(pod);
                double SI = -Math.sin(pod);

                double TR = 0;
                double TI = 0;

                for (J = 1; J <= LE2; J++) {
                    int JM1 = J - 1;

                    for (int I = JM1; I <= NM1; I = I + LE) {
                        int IP = I + LE2;

                        TR = complex[0][IP] * (double) UR - complex[1][IP] * (double) UI;
                        TI = complex[0][IP] * (double) UI + complex[1][IP] * (double) UR;
                        complex[0][IP] = complex[0][I] - TR;
                        complex[1][IP] = complex[1][I] - TI;
                        complex[0][I] = complex[0][I] + TR;
                        complex[1][I] = complex[1][I] + TI;
                    }

                    double TMR = UR;

                    UR = TMR * SR - UI * SI;
                    UI = TMR * SI + UI * SR;

                }
            } 
        } catch (Exception e) {
            System.err.println("Exception in fftComplex: " + e.getMessage());
        }

        return complex;
    }

    @Override
    public float[][] ifft(float[][] complex) {
        
        int N = complex[0].length;

        for (int i = 0; i < N; i++) {
            complex[1][i] = -complex[1][i];
        }

        float[][] fftC = fft(complex);

        for (int i = 0; i < N; i++) {
            fftC[0][i] /= (float) N;
            fftC[1][i] /= -(float) N;
        }
        return fftC;
    }

    @Override
    public double[][] ifft(double[][] complex) {
        int N = complex[0].length;

        for (int i = 0; i < N; i++) {
            complex[1][i] = -complex[1][i];
        }

        double[][] fftC = fft(complex);

        for (int i = 0; i < N; i++) {
            fftC[0][i] /= (double) N;
            fftC[1][i] /= -(double) N;
        }
        return fftC;
    }

    
}
