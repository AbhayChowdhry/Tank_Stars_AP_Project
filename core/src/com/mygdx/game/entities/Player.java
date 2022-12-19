package com.mygdx.game.entities;

import java.io.Serializable;
import java.util.LinkedList;

public class Player implements Serializable {
    private Tank tank;

    // Total health is 100
    private int health;

    // Total fuel is 10
    private float fuel;
    private int power;

    Player() {
        this.fuel=10;
        this.health=100;
        this.power = 10;
    }


    public float getFuel() {
        return fuel;
    }

    public int getHealth() {
        return health;
    }

    public void setFuel(float fuel) {
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

    public int getPower() { return power; }

    public void setPower(int power) { this.power = power; }
}
