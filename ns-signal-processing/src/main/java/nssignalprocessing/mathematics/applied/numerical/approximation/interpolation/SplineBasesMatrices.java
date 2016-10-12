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
package nssignalprocessing.mathematics.applied.numerical.approximation.interpolation;

/**
 *
 * @author xjuraj
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
