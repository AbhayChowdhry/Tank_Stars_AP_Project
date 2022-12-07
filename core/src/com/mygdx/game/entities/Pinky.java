package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Pinky extends Tank{

    private Texture PINKY_BODY = new Texture("PINKY_BODY.png");
    private Texture PINKY_SNOUT = new Texture("PINKY_SNOUT.png");
    Sprite body = new Sprite(PINKY_BODY);
    Sprite snout = new Sprite(PINKY_SNOUT);
    private Texture SpecialWeapon = new Texture("2_0.png");
    private Texture SharpShooter = new Texture("2_1.png");
    private Texture RainbowAttack = new Texture("2_2.png");
    private Texture MakeItRain = new Texture("2_3.png");
    private Texture MassiveDrop = new Texture("2_4.png");

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

    @Override
    public Sprite getBody() {
        return body;
    }

    @Override
    public Sprite getSnout() {
        return snout;
    }
    private final double tank_width = Game.getWIDTH()/14.979f;
    private final double tank_height = Game.getHEIGHT()/10.8f;
    private final double snout_width = Game.getWIDTH()/26.667f;
    private final double snout_height = Game.getHEIGHT()/54f;
    private final double snout_x = -Game.getWIDTH()/1280f;
    private final double snout_y = -Game.getHEIGHT()/120f;
    @Override
    String name() {
        return "2";
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
}
