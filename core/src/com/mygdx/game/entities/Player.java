package com.mygdx.game.entities;

import java.util.LinkedList;

public class Player {
    private Tank tank;

    // Total health is 100
    private int health;

    // Total fuel is 10
    private int fuel;

    private LinkedList<Weapon> weapons;

    Player(Tank tank) {
        this.fuel=10;
        this.health=100;
        this.tank=tank;
        this.weapons.add(new SharpShooter());
        this.weapons.add(new RainbowAttack());
        this.weapons.add(new MakeItRain());
        this.weapons.add(new MassiveDrop());
    }


    public int getFuel() {
        return fuel;
    }

    public int getHealth() {
        return health;
    }

    public void setFuel(int fuel) {
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
