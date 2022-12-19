package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

import java.util.concurrent.TransferQueue;

public class Pumpkin extends Tank{

     private Texture PUMPKIN_BODY = new Texture("PUMPKIN_BODY.png");
     private Texture PUMPKIN_SNOUT = new Texture("PUMPKIN_SNOUT.png");
     private Texture SpecialWeapon = new Texture("1_0.png");
     private Texture SharpShooter = new Texture("1_1.png");
     private Texture RainbowAttack = new Texture("1_2.png");
     private Texture MakeItRain = new Texture("1_3.png");
     private Texture MassiveDrop = new Texture("1_4.png");

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
    Sprite body = new Sprite(PUMPKIN_BODY);
    Sprite snout = new Sprite(PUMPKIN_SNOUT);

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
