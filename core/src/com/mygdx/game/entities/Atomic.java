package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

import java.io.Serializable;

public class Atomic extends Tank implements Serializable {

    private transient Texture ATOMIC_BODY = new Texture("ATOMIC_BODY.png");
    private transient Texture ATOMIC_SNOUT = new Texture("ATOMIC_SNOUT.png");

    private transient Texture SpecialWeapon = new Texture("4_0.png");
    private transient Texture SharpShooter = new Texture("4_1.png");
    private transient Texture MakeItRain = new Texture("4_3.png");
    private transient Texture MassiveDrop = new Texture("4_4.png");

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

    transient Sprite body = new Sprite(ATOMIC_BODY);
    transient Sprite snout = new Sprite(ATOMIC_SNOUT);
    @Override
    public Sprite getBody() {

        return body;
    }

    @Override
    public Sprite getSnout() {

        return snout;
    }
    private final double tank_width = Game.getWIDTH()/12.8f;
    private final double tank_height = Game.getHEIGHT()/14.448;
    private final double snout_width = Game.getWIDTH()/13.567f;
    private final double snout_height = Game.getHEIGHT()/26.341;
    private final double snout_x = Game.getWIDTH()/137.14f;
    private final double snout_y = Game.getHEIGHT()/22.618f;

    public double getSnout_height() {
        return snout_height;
    }

    public double getSnout_width() {
        return snout_width;
    }

    @Override
    public double getTank_height() {
        return tank_height;
    }

    @Override
    public double getTank_width() {
        return tank_width;
    }

    public double getSnout_x() {
        return snout_x;
    }

    public double getSnout_y() {
        return snout_y;
    }

}
