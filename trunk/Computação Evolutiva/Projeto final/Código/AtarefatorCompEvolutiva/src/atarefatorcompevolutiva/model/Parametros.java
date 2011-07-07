/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.model;

/**
 *
 * @author Thales
 */
public class Parametros {
    private double initialWeight = 0.7;
    private double c1 = 2;
    private double c2 = 2;
    private int maximumGeneration = 1000;

    public double getC1() {
        return c1;
    }

    public void setC1(double c1) {
        this.c1 = c1;
    }

    public double getC2() {
        return c2;
    }

    public void setC2(double c2) {
        this.c2 = c2;
    }

    public double getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(double initialWeight) {
        this.initialWeight = initialWeight;
    }

    public int getMaximumGeneration() {
        return maximumGeneration;
    }

    public void setMaximumGeneration(int maximumGeneration) {
        this.maximumGeneration = maximumGeneration;
    }
    
}
