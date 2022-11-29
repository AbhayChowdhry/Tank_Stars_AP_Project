package com.mygdx.game.entities;

public class Player {
    private Tank tank;

    // Total health is 100
    private int health;

    // Total fuel is 10
    private double fuel;

    public Player(Tank tank){
        this.tank = new Pumpkin();
        this.health = 100;
        this.fuel = 10;
    }

    Player() {
        this.fuel=10;
        this.health=100;
        this.tank = new Pinky();
    }


    public double getFuel() {
        return fuel;
    }

    public int getHealth() {
        return health;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
