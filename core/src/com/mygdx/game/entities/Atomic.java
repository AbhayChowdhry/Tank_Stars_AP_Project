package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Atomic extends Tank{

    private Texture ATOMIC_BODY = new Texture("ATOMIC_BODY.png");
    private Texture ATOMIC_SNOUT = new Texture("ATOMIC_SNOUT.png");

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
    private final double snout_x = -Game.getWIDTH()/32f;
    private final double snout_y = Game.getHEIGHT()/100f;

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

}
