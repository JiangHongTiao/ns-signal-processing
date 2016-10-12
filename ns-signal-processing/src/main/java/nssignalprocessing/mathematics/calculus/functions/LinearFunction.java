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
package nssignalprocessing.mathematics.calculus.functions;

/**
 * A linear function is a function f which satisfies
 * f(x+y)=f(x)+f(y) 
 * and 
 * f(alpha x)=alpha f(x) 
 * for all x and y in the domain, and all scalars alpha.
 * @author xjuraj
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
