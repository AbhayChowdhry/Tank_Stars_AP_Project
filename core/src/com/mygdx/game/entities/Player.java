package com.mygdx.game.entities;

public class Player {
    private int name;
    private Tank tank;

    // Total health is 100
    private double health;

    // Total fuel is 10
    private double fuel;

    public Player(int name, Tank tank) {
        this.name = name;
        this.tank = new Pumpkin();
        this.health = 100;
        this.fuel = 10;
    }

    public double getFuel() {
        return fuel;
    }

    public double getHealth() {
        return health;
    }

    public int getName() {
        return name;
    }

    public Tank getTank() {
        return tank;
    }
}
