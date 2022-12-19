package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

import java.io.Serializable;

public class SharpShooter extends Weapon implements Serializable {

    private final transient Texture pumpkin = new Texture("1_1.png");
    private final transient Texture pinky = new Texture("2_1.png");
    private final transient Texture toxic = new Texture("3_1.png");
    private final transient Texture atomic = new Texture("4_1.png");
    private final transient Sprite pumpkin_w = new Sprite(new Texture("1_1W.png"));
    private final transient Sprite pinky_w = new Sprite(new Texture("2_1W.png"));
    private final transient Sprite toxic_w = new Sprite(new Texture("3_1W.png"));
    private final transient Sprite atomic_w = new Sprite(new Texture("4_1W.png"));

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
            return Game.getWIDTH()/54.857;
        } else if (tank instanceof Pinky) {
            return Game.getWIDTH()/101.269;
        } else if (tank instanceof Toxic) {
            return Game.getWIDTH()/69.314;
        } else {
            return Game.getWIDTH()/81.081;
        }
    }

    public double getHeight(Tank tank) {
        if (tank instanceof Pumpkin) {
            return Game.getHEIGHT()/108f;
        } else if (tank instanceof Pinky) {
            return Game.getHEIGHT()/67.5;
        } else if (tank instanceof Toxic) {
            return Game.getHEIGHT()/83.077;
        } else {
            return Game.getHEIGHT()/108f;
        }
    }
    public int getName() { return 1; }
}
