package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

public class MassiveDrop extends Weapon{
    private final Texture pumpkin = new Texture("1_4.png");
    private final Texture pinky = new Texture("2_4.png");
    private final Texture toxic = new Texture("3_4.png");
    private final Texture atomic = new Texture("4_4.png");

    private final Sprite pumpkin_w = new Sprite(new Texture("1_4W.png"));
    private final Sprite pinky_w = new Sprite(new Texture("2_4W.png"));
    private final Sprite toxic_w = new Sprite(new Texture("3_4W.png"));
    private final Sprite atomic_w = new Sprite(new Texture("4_4W.png"));
    public Texture picture(Tank tank) {
        if (tank instanceof Pumpkin) {
            return pumpkin;
        } else if (tank instanceof Pinky) {
            return pinky;
        } else if (tank instanceof Toxic) {
            return toxic;
        } else {
            return atomic;
        }
    }

    public Sprite weapons(Tank tank) {
        if (tank instanceof Pumpkin) {
            return pumpkin_w;
        } else if (tank instanceof Pinky) {
            return pinky_w;
        } else if (tank instanceof Toxic) {
            return toxic_w;
        } else {
            return atomic_w;
        }
    }
    public double getWidth(Tank tank) {
        if (tank instanceof Pumpkin) {
            return Game.getWIDTH()/15f;
        } else if (tank instanceof Pinky) {
            return Game.getWIDTH()/12.8f;
        } else if (tank instanceof Toxic) {
            return Game.getWIDTH()/8.232f;
        } else {
            return Game.getWIDTH()/11.611f;
        }
    }

    public double getHeight(Tank tank) {
        if (tank instanceof Pumpkin) {
            return Game.getHEIGHT()/9f;
        } else if (tank instanceof Pinky) {
            return Game.getHEIGHT()/10.8f;
        } else if (tank instanceof Toxic) {
            return Game.getHEIGHT()/20f;
        } else {
            return Game.getHEIGHT()/10.093f;
        }
    }

    public int getName() { return 4; }
}
