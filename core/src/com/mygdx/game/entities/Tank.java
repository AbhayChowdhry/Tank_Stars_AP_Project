package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Tank implements Serializable {

    protected Sprite body, snout;

    private double tank_width;
    private double tank_height;
    private double snout_width;
    private double snout_height;
    private double snout_x;
    private double snout_y;
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
