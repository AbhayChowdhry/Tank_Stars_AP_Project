package com.mygdx.game.entities;

public class Player {
    private int name;
    private Tank tank;

    // Total health is 100
    private double health;

    // Total fuel is 10
    private double fuel;

    Player(int name, Tank tank) {
        this.name = name;
        this.tank = tank;
        this.health = 100;
        this.fuel = 10;
    }
}
