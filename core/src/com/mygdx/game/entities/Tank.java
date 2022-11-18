package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;

public abstract class Tank {

    protected Texture body, snout;
    protected float x_body = 0;
    protected float y_body = 0;
    protected float x_snout;
    protected float y_snout;

    protected static final float SPEED = 50;
//    abstract void fire();
//    abstract void selectWeapon();
//    abstract void drawTank();
    public void forward(){
        x_body += 4;
        x_snout += 4;
    }
    public void backward(){
        x_body -= 4;
        x_snout -= 4;
    }

    public Texture getBody() {
        return body;
    }
    public Texture getSnout() {
        return snout;
    }

    public float getX_body() {
        return x_body;
    }

    public float getX_snout() {
        return x_snout;
    }

    public float getY_body() {
        return y_body;
    }

    public float getY_snout() {
        return y_snout;
    }

    public static float getSPEED() {
        return SPEED;
    }
}
