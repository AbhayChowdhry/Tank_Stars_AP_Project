package com.mygdx.game.entities;

abstract class Tank {
    private static final float SPEED = 50;
    abstract void fire();
    abstract void selectWeapon();
    abstract void drawTank();
    private float x, y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public static float getSPEED() {
        return SPEED;
    }

    void move_forward() {
        x += SPEED;
    }

    void move_backward() {
        x -= SPEED;
    }
}
