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
     private transient Texture RainbowAttack = new Texture("1_2.png");
     private transient Texture MakeItRain = new Texture("1_3.png");
     private transient Texture MassiveDrop = new Texture("1_4.png");

    public Texture getMakeItRain() {
        return MakeItRain;
    }

    public Texture getMassiveDrop() {
        return MassiveDrop;
    }

    public Texture getRainbowAttack() {
        return RainbowAttack;
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

    private final double snout_x_flip = 0;
    private final double snout_y_flip = Game.getHEIGHT()/26.554f;
    @Override
    String name() {
        return "1";
    }

    public void move_forward(){
        x_body += 4;
    }
    public void move_backward(){
        x_body -= 4;
    }


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

        public double getSnout_x_flip() {
            return snout_x_flip;
        }

    public double getSnout_y_flip() {
        return snout_y_flip;
    }
}
