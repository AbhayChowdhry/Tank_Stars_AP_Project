package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Toxic extends Tank{


    private Texture TOXIC_BODY = new Texture("TOXIC_BODY.png");
    private Texture TOXIC_SNOUT = new Texture("TOXIC_SNOUT.png");
    Sprite body = new Sprite(TOXIC_BODY);
    Sprite snout = new Sprite(TOXIC_SNOUT);
    private Texture SpecialWeapon = new Texture("3_0.png");
    private Texture SharpShooter = new Texture("3_1.png");
    private Texture MakeItRain = new Texture("3_3.png");
    private Texture MassiveDrop = new Texture("3_4.png");


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


    @Override
    public Sprite getBody() {
        return body;
    }

    @Override
    public Sprite getSnout() {
        return snout;
    }


    private final double tank_width = Game.getWIDTH()/16.407f;
    private final double tank_height = Game.getHEIGHT()/13.5;
    private final double snout_width = Game.getWIDTH()/22.746f;
    private final double snout_height = Game.getHEIGHT()/38.571f;
    private final double snout_x = Game.getWIDTH()/40f;
    private final double snout_y = Game.getHEIGHT()/31.768f;
    private final double snout_x_flip = 0;
//    private final double snout_x_flip = - Game.getWIDTH()/125.49;
    private final double snout_y_flip = Game.getHEIGHT()/31.768f;
    private final double snout_x_shift = - Game.getWIDTH()/27.81;
    private final double snout_y_shift= Game.getHEIGHT()/31.768f;


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

    public double getSnout_x_shift() {
        return snout_x_shift;
    }

    @Override
    public double getSnout_x_flip() {
        return snout_x_flip;
    }

    @Override
    public double getSnout_y_flip() {
        return snout_y_flip;
    }

    public double getSnout_y_shift() {
        return snout_y_shift;
    }
}
