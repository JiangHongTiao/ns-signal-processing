/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.calculus.functions;

/**
 * A linear function is a function f which satisfies
 * f(x+y)=f(x)+f(y) 
 * and 
 * f(alpha x)=alpha f(x) 
 * for all x and y in the domain, and all scalars alpha.
 * @author jurco
 */
public class LinearFunction {
    
    /**
     * Generate linear spece of equally distributed points in range: from-to.
     * @param from Start value (inclusive)
     * @param to End value (inclusive)
     * @param numberOfPoints number of generated points
     * @return array of length numberOfPoints with equally distributed points in range: from-to.
     */
    public static double[] linearSpace(double from, double to, int numberOfPoints){
        double addConstant = (to-from)/((double)numberOfPoints-1.);
        return arithmeticSerie(from, addConstant, numberOfPoints);
    }
    
    /**
     * Arithmetic serie generation with starting point, constant change and length of the serie. 
     * @param from Starting point (inclusive)
     * @param addConstant adding constant
     * @param numberOfPoints length of serie
     * @return airthmetic serie of points with constantly increasing value
     */
    public static double[] arithmeticSerie(double from, double addConstant, int numberOfPoints){
        double[] result = new double[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            result[i] = i*addConstant+from;
        }
        return result;
    }
    
}
