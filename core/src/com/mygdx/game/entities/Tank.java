package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public abstract class Tank {

    protected Sprite body, snout;
    protected float x_body = 0;
    protected float y_body = 0;
    protected float x_snout;
    protected float y_snout;

    private double tank_width;
    private double tank_height;
    private double snout_width;
    private double snout_height;
    private double snout_x;
    private double snout_y;

    protected static final float SPEED = 50;
//    abstract void fire();
//    abstract void selectWeapon();
//    abstract void drawTank();

    abstract String name();

    public void forward(){
        x_body += 4;
        x_snout += 4;
    }
    public void backward(){
        x_body -= 4;
        x_snout -= 4;
    }

    public Sprite getBody() {
        return body;
    }
    public Sprite getSnout() {
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

    public double getTank_height() {
        return tank_height;
    }

    public double getTank_width() {
        return tank_width;
    }

    public double getSnout_height() {
        return snout_height;
    }

    public double getSnout_width() {
        return snout_width;
    }

    public double getSnout_x() {
        return snout_x;
    }

    public double getSnout_y() {
        return snout_y;
    }

    public static float getSPEED() {
        return SPEED;
    }
}
