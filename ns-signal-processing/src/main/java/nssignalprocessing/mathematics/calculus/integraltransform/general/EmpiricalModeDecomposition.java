/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.calculus.integraltransform.general;

import nssignalprocessing.mathematics.applied.numerical.approximation.interpolation.CubicSpline;
import nssignalprocessing.mathematics.applied.numerical.approximation.interpolation.SplineBasesMatrices;
import nssignalprocessing.mathematics.calculus.functions.IntrinsicModeFunction;
import nssignalprocessing.mathematics.calculus.functions.LinearFunction;
import nssignalprocessing.mathematics.calculus.incdec.MonotonicFunction;
import nssignalprocessing.mathematics.calculus.minmax.Maxima;
import nssignalprocessing.mathematics.calculus.minmax.Minima;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author jurco
 */
public class EmpiricalModeDecomposition {
    
    public static double[][] doEMD(double[] signal){
        return doEMD(signal,0, signal.length, 0.25, 1000);
    }
    
    public static double[][] doEMD(double[] signal, int from, int to){
        return doEMD(signal,from, to, 0.25, 1000);
    }
    
    /**
     * 
     * @param signal
     * @param from
     * @param to
     * @param stopImfStd "To guarantee that the IMF components retain enough physical 
     * sense of both amplitude and frequency modulations, we have to determine a 
     * criterion for the sifting process to stop. A typical value for SD can be 
     * set between 0.2 and 0.3. As a comparison, the two Fourier spectra, 
     * computed by shifting only five out of 1024 points from the same data, 
     * can have an equivalent SD of 0.2–0.3 calculated point-by-point. Therefore, 
     * a SD value of 0.2–0.3 for the sifting procedure is a very rigorous limitation 
     * for the difference between siftings." Huang, Norden E. et al 
     * "The empirical mode decomposition and the Hilbert spectrum for nonlinear 
     * and non-stationary time series analysis." Proceedings of the Royal Society 
     * of London A: Mathematical, Physical and Engineering Sciences 454.1971 
     * (1998): 903-995. Web.01 June. 2016.
     * @param maxImfLevels
     * @return 
     */
    public static double[][] doEMD(double[] signal, int from, int to, double stopImfStd, int maxImfLevels){
        List<double[]> imf = new LinkedList<>();
        int range=to-from;
        double[] x = new double[range];
        System.arraycopy(signal, from, x, 0, range);//we do backup of the 
        double[] t = LinearFunction.arithmeticSerie(0.0, 1.0, x.length);
        
        for (int i = 0; i < maxImfLevels; i++) {
            if(MonotonicFunction.isMonotonic(x))break;
            double[] x1=x;
            double sd = Double.POSITIVE_INFINITY;
//            int imfTurn=0;
            while(sd > stopImfStd || !IntrinsicModeFunction.isIMF(x1)){
//                System.out.println("x"+imfTurn+"="+Arrays.toString(x1)+";");
                Pair<int[], double[]> max = getSplineMinMax(Maxima.getAllMaximaWithIndexes(x1), x.length-1);
                Pair<int[], double[]> min = getSplineMinMax(Minima.getAllMinimaWithIndexes(x1), x.length-1);
                //padding beginning and end with zeros or end of the array index
                double[] s1=CubicSpline.eval(t, max.getKey(), max.getValue(), SplineBasesMatrices.CATMULL_ROM);
                double[] s2=CubicSpline.eval(t, min.getKey(), min.getValue(), SplineBasesMatrices.CATMULL_ROM);
                //x2 = x1-(s1+s2)/2;
                double[] x2=new double[x1.length];
                for (int j = 0; j < x1.length; j++) x2[j]=x1[j]-(s2[j]+s1[j])/2.f;
                
                double sqSum = 0.0;
                double d=0.0;
                sd=0.0;
                for (int j = 0; j < x1.length; j++) {
                    //sum((x1-x2).^2)
                    d=x1[j]-x2[j];
                    sd+=d*d;
                    //sum(x1.^2);
                    sqSum+=x1[j]*x1[j];
                }
                //sd = sum((x1-x2).^2)/sum(x1.^2);
                sd/=sqSum;
                x1=x2;
//                System.out.println(String.format("Lvl: %d\tImfTurn: %d\tSD: %.3f\tIsIMF:%b", i,++imfTurn, sd, IntrinsicModeFunction.isIMF(x1)));
            }
            imf.add(x1);
            for (int j = 0; j < x1.length; j++) x[j]=x[j]-x1[j];
//            System.out.println(String.format("IsMonotonic(x):%b", MonotonicFunction.isMonotonic(x)));
        }
        imf.add(x);
        return imf.toArray(new double[0][]);
    }
    
    private static Pair<int[], double[]> getSplineMinMax(Pair<int[], double[]> values, int endValue){
        int[]   x = new int[values.getKey().length+2];
        double[] y = new double[values.getValue().length+2];
        //copy original elements
        System.arraycopy(values.getKey(), 0, x, 1, values.getKey().length);
        System.arraycopy(values.getValue(), 0, y, 1, values.getValue().length);
        x[x.length-1] = endValue;
        return new ImmutablePair<>(x,y);
    }
    
}
