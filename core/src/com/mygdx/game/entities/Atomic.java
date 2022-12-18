package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Atomic extends Tank{

    private Texture ATOMIC_BODY = new Texture("ATOMIC_BODY.png");
    private Texture ATOMIC_SNOUT = new Texture("ATOMIC_SNOUT.png");

    private Texture SpecialWeapon = new Texture("4_0.png");
    private Texture SharpShooter = new Texture("4_1.png");
    private Texture RainbowAttack = new Texture("4_2.png");
    private Texture MakeItRain = new Texture("4_3.png");
    private Texture MassiveDrop = new Texture("4_4.png");

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

    Sprite body = new Sprite(ATOMIC_BODY);
    Sprite snout = new Sprite(ATOMIC_SNOUT);
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

    private final double snout_x_flip = 0;
    //    private final double snout_x_flip = - Game.getWIDTH()/125.49;
    private final double snout_y_flip = Game.getHEIGHT()/22.618f;

//    private float x_body = 0;
//    private float y_body = 0;
//    private float x_snout = x_body;
    // private float y_snout = (float) (y_body + Game.getHEIGHT()/5.0232);
    //private float y_snout = (float) (y_body + 215);


    @Override
    String name() {
        return "4";
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

    @Override
    public double getSnout_x_flip() {
        return snout_x_flip;
    }

    @Override
    public double getSnout_y_flip() {
        return snout_y_flip;
    }
}
