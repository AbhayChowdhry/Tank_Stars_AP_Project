package com.mygdx.game.entities;

public class Player {
    private int SPEED = 4;
    private int x_coord;
    private int y_coord;
    private Tank tank;
    private int health;
    private double fuel;

    public Player(Tank tank){
        this.tank = new Pumpkin();
        this.health = 100;
        this.fuel = 10;
    }

    Player() {
        this.fuel=10;
        this.health=100;
    }

    public void move_forward(){
        this.x_coord += SPEED;
    }
    public void move_backward(){
        this.x_coord -= SPEED;
    }
    public int getX_coord() {
        return x_coord;
    }

    public int getY_coord() {
        return y_coord;
    }

    public double getFuel() {
        return fuel;
    }

    public int getHealth() {
        return health;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
