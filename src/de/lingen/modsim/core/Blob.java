package de.lingen.modsim.core;

public abstract class Blob implements ISimulationObject {

    private double energy;
    private double speed;
    private double size;
    private double sense;

    private Point2D pos;

    public Blob(Point2D pos) {
        energy = 100;
        speed  = 0.5;
        size   = 1;
        sense  = 1;

        this.pos = pos;
    }

    public Blob(double energy, double speed, double size, double sense, Point2D pos) {
        this.energy = energy;
        this.speed  = speed;
        this.size   = size;
        this.sense  = sense;

        this.pos = pos;
    }

    public void calculateEnergyCostPerTimeFrame() {
//        energy = Math.pow(size,3) + Math.pow(speed,2) + sense;
        // size^3 + speed^2 + sense
        energy = (size * size * size) + (speed * speed) + sense;
    }


    /**
     * s = v * t
     * strecke = geschwindigkeit * zeit
     */
    public void move() {
        //TODO move
    }

    public abstract void moveStrategy();

    public double getEnergy() {
        return energy;
    }

    public double getSpeed() {
        return speed;
    }

    public double getSize() {
        return size;
    }

    public double getSense() {
        return sense;
    }
}