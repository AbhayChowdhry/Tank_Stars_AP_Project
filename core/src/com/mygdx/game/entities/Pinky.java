package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Pinky extends Tank{

    private Texture body_texture = new Texture("pinky_body.png");
    private Texture snout_texture = new Texture("pinky_snout.png");
    private Texture extra_texture = new Texture("pinky_extra.png");

//    private float x_body = 0;
//    private float y_body = 0;
//    private float x_snout = x_body;
    // private float y_snout = (float) (y_body + Game.getHEIGHT()/5.0232);
    // private float y_snout = (float) (y_body + 215);

    private double tank_width = Game.getWIDTH()/7.0;
    private double tank_height = Game.getHEIGHT()/8.0;

    Sprite body = new Sprite(body_texture);
    Sprite snout = new Sprite(snout_texture);
    Sprite extra = new Sprite(extra_texture);

    public void move_forward(){
        x_body += 4;
    }
    public void move_backward(){
        x_body -= 4;
    }

    @Override
    public Sprite getBody() {
        return body;
    }

    @Override
    public Sprite getSnout() {
        return snout;
    }

    public Sprite getExtra() {
        return extra;
    }
}
