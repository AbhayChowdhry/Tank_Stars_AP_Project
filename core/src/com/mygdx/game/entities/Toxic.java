package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class Toxic extends Tank{


    private Texture TOXIC_BODY = new Texture("TOXIC_BODY.png");
    private Texture TOXIC_SNOUT = new Texture("TOXIC_SNOUT.png");
    Sprite body = new Sprite(TOXIC_BODY);
    Sprite snout = new Sprite(TOXIC_SNOUT);
    @Override
    public Sprite getBody() {
        return body;
    }

    @Override
    public Sprite getSnout() {
        return snout;
    }


    private final double tank_width = Game.getWIDTH()/16.407f;
    private final double tank_height = Game.getHEIGHT()/13.5;
    private final double snout_width = Game.getWIDTH()/22.746f;
    private final double snout_height = Game.getHEIGHT()/38.571f;
    private final double snout_x = -Game.getWIDTH()/192f;
    private final double snout_y = -Game.getHEIGHT()/360f;

    @Override
    String name() {
        return "3";
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
