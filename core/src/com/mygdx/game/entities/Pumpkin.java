package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.mygdx.game.Game;

import java.io.Serializable;

public class Pumpkin extends Tank implements Serializable {

     private transient Texture PUMPKIN_BODY = new Texture("PUMPKIN_BODY.png");
     private transient Texture PUMPKIN_SNOUT = new Texture("PUMPKIN_SNOUT.png");
     private transient Texture SpecialWeapon = new Texture("1_0.png");
     private transient Texture SharpShooter = new Texture("1_1.png");
     private transient Texture MakeItRain = new Texture("1_3.png");
     private transient Texture MassiveDrop = new Texture("1_4.png");

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

    transient Sprite body = new Sprite(PUMPKIN_BODY);
    transient Sprite snout = new Sprite(PUMPKIN_SNOUT);

    @Override
    public Sprite getBody() {
        return body;
    }

    @Override
    public Sprite getSnout() {
        return snout;
    }


    private final double tank_width = Game.getWIDTH()/15f;
    private final double tank_height = Game.getHEIGHT()/15.960;
    private final double snout_width = Game.getWIDTH()/28.223f;
    private final double snout_height = Game.getHEIGHT()/38.571f;
    private final double snout_x = Game.getWIDTH()/31.475f;
    private final double snout_y = Game.getHEIGHT()/26.554f;

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
    public double getTank_width() { return tank_width; }

    public double getSnout_x() {
        return snout_x;
    }

    public double getSnout_y() {
        return snout_y;
    }
}
