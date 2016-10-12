/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nssignalprocessing.mathematics.applied.numerical.approximation.interpolation;

/**
 *
 * @author jurco
 */
public class SplineBasesMatrices {
    
    public static final double[][] BEZIER = { // Bezier basis matrix
        {-1, 3, -3, 1},
        {3, -6, 3, 0},
        {-3, 3, 0, 0},
        {1, 0, 0, 0}
    };
    public static final double[][] BSPLINE = { // BSpline basis matrix
        {-1. / 6, 3. / 6, -3. / 6, 1. / 6},
        {3. / 6, -6. / 6, 3. / 6, 0.},
        {-3. / 6, 0., 3. / 6, 0.},
        {1. / 6, 4. / 6, 1. / 6, 0.}
    };
    public static final double[][] CATMULL_ROM = { // Catmull-Rom basis matrix
        {-0.5, 1.5, -1.5, 0.5},
        {1, -2.5, 2, -0.5},
        {-0.5, 0, 0.5, 0},
        {0, 1, 0, 0}
    };
    public static final double[][] HERMITE = { // Hermite basis matrix
        {2, -2, 1, 1},
        {-3, 3, -2, -1},
        {0, 0, 1, 0},
        {1, 0, 0, 0}
    };

}
