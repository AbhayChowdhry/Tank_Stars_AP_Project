package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Tank implements Serializable {

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
    private double snout_x_flip;
    private double snout_y_flip;
    private double snout_x_shift;
    private double snout_y_shift;
    private transient Texture PUMPKIN_SNOUT;

    private transient Texture SpecialWeapon;
    private transient Texture SharpShooter;
    private transient Texture MakeItRain;
    private transient Texture MassiveDrop;
    protected static final float SPEED = 50;

    private LinkedList<Weapon> weapons;

    Tank(){
        weapons = new LinkedList<Weapon>();
        this.weapons.add(new SharpShooter());
        this.weapons.add(new MakeItRain());
        this.weapons.add(new MassiveDrop());
    }

    public LinkedList<Weapon> getWeapons() {
        return weapons;
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

    public double getSnout_x_flip() {
        return snout_x_flip;
    }

    public double getSnout_y_flip() {
        return snout_y_flip;
    }

    public double getSnout_x_shift() {
        return snout_x_shift;
    }

    public double getSnout_y_shift() {
        return snout_y_shift;
    }

    public double getTank_height() {
        return tank_height;
    }

    public double getTank_width() {
        return tank_width;
    }

    public Texture getPUMPKIN_SNOUT() {
        return PUMPKIN_SNOUT;
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

    public Texture getMakeItRain() {
        return MakeItRain;
    }

    public Texture getMassiveDrop() {
        return MassiveDrop;
    }

    public Texture getSharpShooter() {
        return SharpShooter;
    }

    public Texture getSpecialWeapon() {
        return SpecialWeapon;
    }
}
