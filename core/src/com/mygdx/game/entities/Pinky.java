package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Pinky extends Tank{

    private Texture PINKY_BODY = new Texture("PINKY_BODY.png");
    private Texture PINKY_SNOUT = new Texture("PINKY_SNOUT.png");
    private Texture PINKY_EXTRAS = new Texture("PINKY_EXTRAS.png");

    Sprite body = new Sprite(PINKY_BODY);
    Sprite snout = new Sprite(PINKY_SNOUT);
    Sprite extras = new Sprite(PINKY_EXTRAS);

    @Override
    public Sprite getBody() {

        return body;
    }

    @Override
    public Sprite getSnout() {

        return snout;
    }

    public Sprite getExtras() {
        return extras;
    }
    //    private float x_body = 0;
//    private float y_body = 0;
//    private float x_snout = x_body;
    // private float y_snout = (float) (y_body + Game.getHEIGHT()/5.0232);
    // private float y_snout = (float) (y_body + 215);


    @Override
    String name() {
        return "2";
    }

    private double tank_width = Game.getWIDTH()/7.0;
    private double tank_height = Game.getHEIGHT()/8.0;

    public void move_forward(){
        x_body += 4;
    }
    public void move_backward(){
        x_body -= 4;
    }
}
