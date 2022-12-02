package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Toxic extends Tank{


    private Texture TOXIC_BODY = new Texture("TOXIC_BODY.png");
    private Texture TOXIC_SNOUT = new Texture("TOXIC_SNOUT.png");
    private Texture TOXIC_EXTRAS = new Texture("TOXIC_EXTRAS.png");

    Sprite body = new Sprite(TOXIC_BODY);
    Sprite snout = new Sprite(TOXIC_SNOUT);
    Sprite extras = new Sprite(TOXIC_EXTRAS);

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
        return "3";
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
