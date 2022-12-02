package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Pumpkin extends Tank{

     private Texture PUMPKIN_BODY = new Texture("PUMPKIN_BODY.png");
     private Texture PUMPKIN_SNOUT = new Texture("PUMPKIN_SNOUT.png");

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
    private float x_body = 0;
    private float y_body = 0;
    private float x_snout = x_body;
     // private float y_snout = (float) (y_body + Game.getHEIGHT()/5.0232);
    private float y_snout = (float) (y_body + 215);


    private double tank_width = Game.getWIDTH()/7.0;
    private double tank_height = Game.getHEIGHT()/8.0;

    // Sprite body, snout;


//    body.setSize(326,183);
//    body.setOrigin(0,0);


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



    @Override
    public double getTank_height() {
        return tank_height;
    }

    @Override
    public double getTank_width() {
        return tank_width;
    }


}
