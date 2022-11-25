package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Pumpkin extends Tank{

     private Texture body_texture = new Texture("pumpkin_body.png");
     private Texture snout_texture = new Texture("pumpkin_snout.png");

    private float x_body = 0;
    private float y_body = 0;
    private float x_snout = x_body;
     // private float y_snout = (float) (y_body + Game.getHEIGHT()/5.0232);
    private float y_snout = (float) (y_body + 215);


    private double tank_width = Game.getWIDTH()/7.0;
    private double tank_height = Game.getHEIGHT()/8.0;

    // Sprite body, snout;
    Sprite body = new Sprite(body_texture);
    Sprite snout = new Sprite(snout_texture);

//    body.setSize(326,183);
//    body.setOrigin(0,0);


    public void move_forward(){
        x_body += 4;
    }
    public void move_backward(){
        x_body -= 4;
    }

    @Override
    void fire() {

    }

    @Override
    void selectWeapon() {

    }

    @Override
    public Sprite getBody() {
        return body;
    }

    @Override
    public Sprite getSnout() {
        return snout;
    }

    @Override
    public double getTank_height() {
        return tank_height;
    }

    @Override
    public double getTank_width() {
        return tank_width;
    }
}
