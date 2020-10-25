package com.cg.stateanalyser;

public class StateCensus {
    private String state, population, area, density;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String toString() {
        return "Name : " + getState() + ", Population : " + getPopulation() + ", Area : " + getArea() + ", Density : " + getDensity();
    }
}
