package ru.rakhimova.junglesimulator.entity;

public class Bear {

    private int health = 100;
    private int energy = 100;
    private double fangs = 3.5;
    private double claws = 2.5;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setFangs(double fangs) {
        this.fangs = fangs;
    }

    public double getFangs() {
        return this.fangs;
    }

    public void setClaws(double claws) {
        this.claws = claws;
    }

    public double getClaws() {
        return this.claws;
    }

}
