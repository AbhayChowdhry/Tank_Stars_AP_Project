package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

public class Atomic extends Tank{

    private Texture body = new Texture("atomic_body.png");
    private Texture snout = new Texture("atomic_snout.png");

    private float x_body = 0;
    private float y_body = 0;
    private float x_snout = x_body;
    // private float y_snout = (float) (y_body + Game.getHEIGHT()/5.0232);
    private float y_snout = (float) (y_body + 215);

    private double tank_width = Game.getWIDTH()/7.0;
    private double tank_height = Game.getHEIGHT()/8.0;

    public void move_forward(){
        x_body += 4;
    }
    public void move_backward(){
        x_body -= 4;
    }

    @Override
    public Texture getBody() {
        return body;
    }

    @Override
    public Texture getSnout() {
        return snout;
    }
}
